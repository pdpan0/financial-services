package br.com.pdpano.msusers.usecase.getuserbyid

import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.GetUserByIdDTO
import org.springframework.stereotype.Service

@Service
class GetUserByIdUseCaseImpl(private val gateway: UserGateway) : GetUserByIdUseCase {
    override fun execute(input: Long): GetUserByIdDTO = gateway.getUserById(input).let(::map)

    private fun map(source: User) = GetUserByIdDTO(
        idUser = source.idUser,
        fullName = source.fullName,
        email = source.email,
        taxNumber = source.taxNumber,
        vlBalance = source.vlBalance,
        isShopkeeper = source.isShopkeeper,
        createdAt = source.createdAt,
        isActive = source.isActive
    )
}