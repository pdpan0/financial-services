package br.com.pdpano.mstransactions.adapters

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain._response.ResponseMessage
import br.com.pdpano.mstransactions.domain.transactions.Transaction
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

interface TransactionControllerSwagger {

    @Operation(description = "Cria uma transação")
    fun createTransaction(transaction: CreateTransactionDTO): ResponseEntity<ResponseMessage<Long>>

    @Operation(description = "Conclui uma transação")
    fun commitTransaction(idTransaction: Long)

    @Operation(description = "Consulta transação por identificador")
    fun getTransactionById(@PathVariable idTransaction: Long): ResponseEntity<ResponseMessage<Transaction>>
}
