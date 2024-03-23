package br.com.pdpano.msusers.usecase.validateuser

import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import org.springframework.stereotype.Service

@Service
class ValidateUserUseCaseImpl: ValidateUserUseCase {
    override fun execute(input: CreateUserDTO): Boolean {
        TODO("Not yet implemented")
    }
}