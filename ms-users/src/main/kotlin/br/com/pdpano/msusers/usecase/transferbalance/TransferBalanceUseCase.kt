package br.com.pdpano.msusers.usecase.transferbalance

import br.com.pdpano.msusers.domain._dto.TransferBalanceDTO
import br.com.pdpano.msusers.usecase.UseCase

interface TransferBalanceUseCase: UseCase<TransferBalanceDTO, Boolean> {
    override fun execute(input: TransferBalanceDTO): Boolean
}