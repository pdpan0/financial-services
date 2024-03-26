package br.com.pdpano.msusers.adapters

import br.com.pdpano.msusers.domain._response.ResponseMessage
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._dto.GetUserByIdDTO
import br.com.pdpano.msusers.domain._dto.TransferBalanceDTO
import br.com.pdpano.msusers.usecase.createuser.CreateUserUseCase
import br.com.pdpano.msusers.usecase.getuserbyid.GetUserByIdUseCase
import br.com.pdpano.msusers.usecase.transferbalance.TransferBalanceUseCase
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
@RequestMapping("v1/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val transferBalanceUseCase: TransferBalanceUseCase
): UserControllerSwagger {

    @PostMapping
    override fun createUser(@RequestBody body: CreateUserDTO): ResponseEntity<ResponseMessage<Long>> =
        createUserUseCase.execute(body).let { idUser ->
            ResponseEntity
                .created(URI("users/$idUser"))
                .body(ResponseMessage.build(idUser))
        }

    @GetMapping("{idUser}")
    override fun getUserById(@PathVariable idUser: Long): ResponseEntity<ResponseMessage<GetUserByIdDTO>> =
        ResponseEntity.ok(ResponseMessage.build(getUserByIdUseCase.execute(idUser)))

    @PutMapping("transfers")
    override fun transferBalance(@RequestBody body: TransferBalanceDTO): ResponseEntity<ResponseMessage<Boolean>> =
        ResponseEntity.ok(ResponseMessage.build(transferBalanceUseCase.execute(body)))
}