package br.com.pdpano.msusers.usecase.createuser

import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.usecase.validateuser.ValidateUserUseCase
import org.springframework.stereotype.Service

@Service
class CreateUserUseCaseImpl(
    private val validateUserUseCase: ValidateUserUseCase
): CreateUserUseCase {

    override fun execute(input: CreateUserDTO): Long {
        TODO("Not yet implemented")
    }
}