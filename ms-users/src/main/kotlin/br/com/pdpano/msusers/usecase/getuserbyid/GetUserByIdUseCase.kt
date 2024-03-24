package br.com.pdpano.msusers.usecase.getuserbyid

import br.com.pdpano.msusers.domain._dto.GetUserByIdDTO
import br.com.pdpano.msusers.usecase.UseCase

interface GetUserByIdUseCase: UseCase<Long, GetUserByIdDTO> {
    override fun execute(input: Long): GetUserByIdDTO
}
