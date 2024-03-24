package br.com.pdpano.mstransactions.infra.clients

import br.com.pdpano.mstransactions.domain._dto.GetUserByIdDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(value = "users", url = "\${ms-transactions.clients.ms-users}")
interface UserClient {

    @GetMapping(value = ["{idUser}"])
    fun getUserById(@PathVariable idUser: Long): GetUserByIdDTO

}