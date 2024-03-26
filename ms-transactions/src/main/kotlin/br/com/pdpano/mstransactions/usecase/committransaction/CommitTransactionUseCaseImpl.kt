package br.com.pdpano.mstransactions.usecase.committransaction

import br.com.pdpano.mstransactions.domain.transactions.TransactionGateway
import br.com.pdpano.mstransactions.domain.transactions.TransactionStatus
import org.springframework.stereotype.Service

@Service
class CommitTransactionUseCaseImpl(
    private val transactionGateway: TransactionGateway
): CommitTransactionUseCase {
    override fun execute(input: Long): Boolean {
        transactionGateway.getTransactionById(input).let {
            transactionGateway.updateStatus(it.idTransaction, TransactionStatus.SUCCESS)
        }

        return true
    }
}