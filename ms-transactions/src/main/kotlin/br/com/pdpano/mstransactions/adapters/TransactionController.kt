package br.com.pdpano.mstransactions.adapters

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/transactions")
class TransactionController(): TransactionControllerSwagger {

    @PostMapping
    override fun createTransaction(@RequestBody transaction: CreateTransactionDTO) {
        TODO("Not yet implemented")
    }

}