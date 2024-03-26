package br.com.pdpano.mstransactions.domain

import br.com.pdpano.mstransactions.domain._dto.GetUserByIdDTO
import br.com.pdpano.mstransactions.domain._dto.TransferBalanceDTO
import br.com.pdpano.mstransactions.domain._response.ResponseMessage

interface UserGateway {
    fun getUserById(idUser: Long): ResponseMessage<GetUserByIdDTO>
    fun transferBalance(body: TransferBalanceDTO): ResponseMessage<Boolean>
}