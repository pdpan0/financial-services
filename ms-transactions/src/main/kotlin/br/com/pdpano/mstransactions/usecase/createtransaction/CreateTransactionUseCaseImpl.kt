package br.com.pdpano.mstransactions.usecase.createtransaction

import br.com.pdpano.mstransactions.domain.AuthenticatorGateway
import br.com.pdpano.mstransactions.domain.NotificationGateway
import br.com.pdpano.mstransactions.domain.UserGateway
import br.com.pdpano.mstransactions.domain.transactions.TransactionGateway
import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain._dto.TransferBalanceDTO
import br.com.pdpano.mstransactions.domain._exceptions.CreateTransactionException
import br.com.pdpano.mstransactions.domain._exceptions.RequestClientException
import feign.FeignException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CreateTransactionUseCaseImpl(
    private val client: AuthenticatorGateway,
    private val notificationClient: NotificationGateway,
    private val userClient: UserGateway,
    private val transactionGateway: TransactionGateway
): CreateTransactionUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    //TODO: chain of responsability?
    override fun execute(input: CreateTransactionDTO): Long {
        if (input.idPayee == input.idPayer) {
            throw CreateTransactionException("The payer cannot make the transfer to himself")
        }

        logger.info("Getting user information")
        val payee = userClient.getUserById(input.idPayee).result
        val payer = userClient.getUserById(input.idPayer).result

        if (!payee.isActive || !payer.isActive) {
            throw CreateTransactionException("Unable to transfer to inactive users")
        }

        if (payer.isShopkeeper) {
            throw CreateTransactionException("Shopkeeper is not allowed to make transaction")
        }

        if (payer.vlBalance < input.vlTransaction) {
            throw CreateTransactionException("The payer does not have sufficient balance")
        }

        if (requestAuthenticateClient()) {
            throw CreateTransactionException("Transaction not allowed")
        }

         val idTransaction = transactionGateway.createTransaction(input)

        userClient.transferBalance(TransferBalanceDTO(idTransaction, payee.idUser, payer.idUser, input.vlTransaction))

        CoroutineScope(Dispatchers.Default).launch {
            notify()
        }

        return idTransaction
    }


    private fun requestAuthenticateClient(): Boolean = try {
        client.authenticate().message == "Autorizado"
    } catch (e: FeignException) {
        logger.error("OpenFeign returns an error: {}", e.message, e)
        throw RequestClientException("authenticator", e)
    }

    private suspend fun notify() {
        try {
            if (requestNotificationClient()) {
                logger.info("Message sent with successfully")
            }
        } catch (e: RequestClientException) {
            logger.info("Message was not send with successfully")
        }
    }
    private fun requestNotificationClient(): Boolean = try {
        notificationClient.notify().message
    } catch (e: FeignException) {
        logger.error("OpenFeign returns an error: {}", e.message, e)
        throw RequestClientException("notifier", e)
    }
}