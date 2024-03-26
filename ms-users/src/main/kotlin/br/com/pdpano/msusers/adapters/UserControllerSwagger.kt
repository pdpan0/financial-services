package br.com.pdpano.msusers.adapters

import br.com.pdpano.msusers.domain._response.ResponseMessage
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._dto.GetUserByIdDTO
import br.com.pdpano.msusers.domain._dto.TransferBalanceDTO
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity

interface UserControllerSwagger {

    @Operation(description = "Cria um novo usuário")
    fun createUser(body: CreateUserDTO): ResponseEntity<ResponseMessage<Long>>

    @Operation(description = "Consulta o usuário por um identificador")
    fun getUserById(idUser: Long): ResponseEntity<ResponseMessage<GetUserByIdDTO>>

    @Operation(description = "Transfere o saldo do usuário para um beneficiário")
    fun transferBalance(body: TransferBalanceDTO): ResponseEntity<ResponseMessage<Boolean>>
}