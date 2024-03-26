package br.com.pdpano.mstransactions.usecase.gettransactionbyid

import br.com.pdpano.mstransactions.domain.transactions.Transaction
import br.com.pdpano.mstransactions.usecase.UseCase

interface GetTransactionByIdUseCase: UseCase<Long, Transaction> {
    override fun execute(input: Long): Transaction
}
