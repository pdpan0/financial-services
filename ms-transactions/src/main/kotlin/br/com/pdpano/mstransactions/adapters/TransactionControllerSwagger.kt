package br.com.pdpano.mstransactions.adapters

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import io.swagger.v3.oas.annotations.Operation

interface TransactionControllerSwagger {

    @Operation(description = "Creates a transaction")
    fun createTransaction(transaction: CreateTransactionDTO)

}
