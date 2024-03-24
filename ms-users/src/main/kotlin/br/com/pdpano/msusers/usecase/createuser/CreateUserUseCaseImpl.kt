package br.com.pdpano.msusers.usecase.createuser

import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.usecase.validateuser.ValidateUserUseCase
import org.springframework.stereotype.Service

@Service
class CreateUserUseCaseImpl(
    private val validateUserUseCase: ValidateUserUseCase,
    private val gateway: UserGateway
): CreateUserUseCase {

    override fun execute(input: CreateUserDTO): Long {
        validateUserUseCase.execute(input)
        return gateway.createUser(input)
    }
}