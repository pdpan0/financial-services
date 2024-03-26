package br.com.pdpano.mstransactions.adapters

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.usecase.createtransaction.CreateTransactionUseCase
import br.com.pdpano.mstransactions.domain._response.ResponseMessage
import br.com.pdpano.mstransactions.domain.transactions.Transaction
import br.com.pdpano.mstransactions.usecase.committransaction.CommitTransactionUseCase
import br.com.pdpano.mstransactions.usecase.gettransactionbyid.GetTransactionByIdUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("v1/transactions")
class TransactionController(
    private val createTransactionUseCase: CreateTransactionUseCase,
    private val commitTransactionUseCase: CommitTransactionUseCase,
    private val getTransactionByIdUseCase: GetTransactionByIdUseCase
): TransactionControllerSwagger {

    @PostMapping
    override fun createTransaction(
        @RequestBody transaction: CreateTransactionDTO
    ): ResponseEntity<ResponseMessage<Long>> =
        createTransactionUseCase.execute(transaction).let { idTransaction ->
            ResponseEntity
                .created(URI("/v1/transactions/$idTransaction"))
                .body(ResponseMessage.build(idTransaction))
        }

    @GetMapping("{idTransaction}")
    override fun getTransactionById(@PathVariable idTransaction: Long): ResponseEntity<ResponseMessage<Transaction>> =
        ResponseEntity.ok(ResponseMessage.build(getTransactionByIdUseCase.execute(idTransaction)))

    @PutMapping("{idTransaction}/commit")
    override fun commitTransaction(@PathVariable idTransaction: Long) {
        commitTransactionUseCase.execute(idTransaction)
    }

    //TODO: Método para cancelar todas as transações não concluídas.
}