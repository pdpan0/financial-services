package br.com.pdpano.msusers.adapters

import br.com.pdpano.msusers.adapters.response.ResponseMessage
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.usecase.createuser.CreateUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("v1/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase
): UserControllerSwagger {

    @PostMapping
    override fun createUser(@RequestBody user: CreateUserDTO): ResponseEntity<ResponseMessage<Long>> {
        val idUser = createUserUseCase.execute(user)
        return ResponseEntity.created(URI("users/$idUser")).body(ResponseMessage.build(idUser))
    }

}