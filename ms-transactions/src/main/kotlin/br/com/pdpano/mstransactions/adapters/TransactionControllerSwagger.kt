package br.com.pdpano.mstransactions.adapters

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain._response.ResponseMessage
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity

interface TransactionControllerSwagger {

    @Operation(description = "Creates a transaction")
    fun createTransaction(transaction: CreateTransactionDTO): ResponseEntity<ResponseMessage<Long>>

}
