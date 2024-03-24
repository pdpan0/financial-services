package br.com.pdpano.mstransactions.usecase.createtransaction

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.usecase.UseCase

interface CreateTransactionUseCase: UseCase<CreateTransactionDTO, Long> {
    override fun execute(input: CreateTransactionDTO): Long
}