package br.com.pdpano.msusers.usecase.createuser

import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.usecase.UseCase

interface CreateUserUseCase: UseCase<CreateUserDTO, Long> {
    override fun execute(input: CreateUserDTO): Long
}