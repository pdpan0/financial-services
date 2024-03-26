package br.com.pdpano.msusers.usecase.transferbalance

import br.com.pdpano.msusers.domain.TransactionGateway
import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.TransferBalanceDTO
import br.com.pdpano.msusers.domain._exceptions.InvalidTransferBalanceException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class TransferBalanceUseCaseImpl(
    private val userGateway: UserGateway,
    private val transactionGateway: TransactionGateway,
): TransferBalanceUseCase {
    override fun execute(input: TransferBalanceDTO): Boolean {
        val payer = userGateway.getUserById(input.idPayer)
        val payee = userGateway.getUserById(input.idPayer)

        if (!payee.isActive || !payer.isActive) {
            throw InvalidTransferBalanceException("Unable to transfer to inactive users")
        }

        if (payer.isShopkeeper) {
            throw InvalidTransferBalanceException("Shopkeeper is not allowed to make transaction")
        }

        if (payer.vlBalance < input.vlTransaction) {
            throw InvalidTransferBalanceException("The payer does not have sufficient balance")
        }

        val payerNewBalance = payer.vlBalance.minus(input.vlTransaction)
        val payeeNewBalance = payee.vlBalance.plus(input.vlTransaction)

        userGateway.patchUserBalance(input.idPayer, payerNewBalance)
        userGateway.patchUserBalance(input.idPayee, payeeNewBalance)

        transactionGateway.commitTransaction(input.idTransaction)

        return true
    }
}