package br.com.pdpano.mstransactions.usecase.createtransaction

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain._exceptions.CreateTransactionException
import br.com.pdpano.mstransactions.infra.clients.AuthenticatorClient
import br.com.pdpano.mstransactions.infra.clients.NotificationClient
import br.com.pdpano.mstransactions.infra.clients.UserClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine

@Service
class CreateTransactionUseCaseImpl(
    private val client: AuthenticatorClient,
    private val notificationClient: NotificationClient,
    private val userClient: UserClient
): CreateTransactionUseCase {

    override fun execute(input: CreateTransactionDTO): Long {
        val payee = userClient.getUserById(input.idPayee)
        val payer = userClient.getUserById(input.idPayer)

        if (payer.isShopkeeper) {
            throw CreateTransactionException("Shopkeeper does not allowed to transaction")
        }

        if (payer.vlBalance < input.vlTransaction) {
            throw CreateTransactionException("Payer does not have sufficient balance")
        }

        if (client.authenticate() != "Autorizado") {
            throw CreateTransactionException("Transaction not allowed")
        }

        notificationClient.notify()

        return 0L
    }

}