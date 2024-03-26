package br.com.pdpano.msusers.infra.clients

import br.com.pdpano.msusers.domain._response.ResponseMessage
import br.com.pdpano.msusers.domain.TransactionGateway
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@FeignClient(name = "transactions", url = "\${ms-users.clients.ms-transactions}")
interface TransactionClient: TransactionGateway {

    @PutMapping(value = ["/v1/transactions/{idTransaction}/commit"])
    override fun commitTransaction(@PathVariable idTransaction: Long): ResponseMessage<Nothing>
}