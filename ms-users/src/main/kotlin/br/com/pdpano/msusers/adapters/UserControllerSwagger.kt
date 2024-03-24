package br.com.pdpano.msusers.adapters

import br.com.pdpano.msusers.adapters.response.ResponseMessage
import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._dto.GetUserByIdDTO
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity

interface UserControllerSwagger {

    @Operation(description = "Creates an user")
    fun createUser(user: CreateUserDTO): ResponseEntity<ResponseMessage<Long>>

    @Operation(description = "Get an user by id")
    fun getUserById(idUser: Long): ResponseEntity<ResponseMessage<GetUserByIdDTO>>
}