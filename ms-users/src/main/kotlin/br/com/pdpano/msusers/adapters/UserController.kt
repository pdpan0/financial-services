package br.com.pdpano.msusers.adapters

import br.com.pdpano.msusers.adapters.response.ResponseMessage
import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._dto.GetUserByIdDTO
import br.com.pdpano.msusers.usecase.createuser.CreateUserUseCase
import br.com.pdpano.msusers.usecase.getuserbyid.GetUserByIdUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("v1/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
): UserControllerSwagger {

    @PostMapping
    override fun createUser(@RequestBody user: CreateUserDTO): ResponseEntity<ResponseMessage<Long>> {
        val idUser = createUserUseCase.execute(user)
        return ResponseEntity.created(URI("users/$idUser")).body(ResponseMessage.build(idUser))
    }

    @GetMapping("{idUser}")
    override fun getUserById(@PathVariable idUser: Long): ResponseEntity<ResponseMessage<GetUserByIdDTO>> =
        ResponseEntity.ok(ResponseMessage.build(getUserByIdUseCase.execute(idUser)))
}