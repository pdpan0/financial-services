package br.com.pdpano.mstransactions.usecase.createtransaction

import br.com.pdpano.mstransactions.domain.transactions.TransactionGateway
import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain._exceptions.CreateTransactionException
import br.com.pdpano.mstransactions.infra.clients.AuthenticatorClient
import br.com.pdpano.mstransactions.infra.clients.NotificationClient
import br.com.pdpano.mstransactions.infra.clients.UserClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CreateTransactionUseCaseImpl(
    private val client: AuthenticatorClient,
    private val notificationClient: NotificationClient,
    private val userClient: UserClient,
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

        if (client.authenticate().message != "Autorizado") {
            throw CreateTransactionException("Transaction not allowed")
        }

        val idTransaction = transactionGateway.createTransaction(input)

        if (notificationClient.notify().message) {
            logger.info("Message sent with successfully")
        }

        return idTransaction
    }

}