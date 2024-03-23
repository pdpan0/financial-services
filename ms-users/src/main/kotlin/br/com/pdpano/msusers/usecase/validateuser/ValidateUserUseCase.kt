package br.com.pdpano.msusers.usecase.validateuser

import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.usecase.UseCase

interface ValidateUserUseCase: UseCase<CreateUserDTO, Boolean> {
    override fun execute(input: CreateUserDTO): Boolean
}