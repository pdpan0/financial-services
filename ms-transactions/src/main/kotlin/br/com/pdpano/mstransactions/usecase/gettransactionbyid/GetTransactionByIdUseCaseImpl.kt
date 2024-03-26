package br.com.pdpano.mstransactions.usecase.gettransactionbyid

import br.com.pdpano.mstransactions.domain.transactions.Transaction
import br.com.pdpano.mstransactions.domain.transactions.TransactionGateway
import org.springframework.stereotype.Service

@Service
class GetTransactionByIdUseCaseImpl(private val transactionGateway: TransactionGateway) : GetTransactionByIdUseCase {
    override fun execute(input: Long): Transaction =
        transactionGateway.getTransactionById(input)
}