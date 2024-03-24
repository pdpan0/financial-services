package br.com.pdpano.mstransactions.adapters

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.usecase.createtransaction.CreateTransactionUseCase
import br.com.pdpano.mstransactions.domain._response.ResponseMessage
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("v1/transactions")
class TransactionController(
    private val createTransactionUseCase: CreateTransactionUseCase
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

}