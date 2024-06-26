package br.com.pdpano.mstransactions.infra.clients

import br.com.pdpano.mstransactions.domain.UserGateway
import br.com.pdpano.mstransactions.domain._dto.GetUserByIdDTO
import br.com.pdpano.mstransactions.domain._dto.TransferBalanceDTO
import br.com.pdpano.mstransactions.domain._response.ResponseMessage
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@FeignClient(value = "users", url = "\${ms-transactions.clients.ms-users}")
interface UserClient: UserGateway {

    @GetMapping(value = ["/v1/users/{idUser}"])
    override fun getUserById(@PathVariable idUser: Long): ResponseMessage<GetUserByIdDTO>

    @PutMapping(value = ["/v1/users/transfers"])
    override fun transferBalance(body: TransferBalanceDTO): ResponseMessage<Boolean>
}