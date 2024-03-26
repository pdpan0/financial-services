package br.com.pdpano.mstransactions.usecase.committransaction

import br.com.pdpano.mstransactions.usecase.UseCase

interface CommitTransactionUseCase: UseCase<Long, Boolean> {
    override fun execute(input: Long): Boolean
}