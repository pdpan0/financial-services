package br.com.pdpano.msusers.adapters

import br.com.pdpano.msusers.adapters.response.ResponseMessage
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity

interface UserControllerSwagger {

    @Operation(description = "Creates an user")
    fun createUser(user: CreateUserDTO): ResponseEntity<ResponseMessage<Long>>

}