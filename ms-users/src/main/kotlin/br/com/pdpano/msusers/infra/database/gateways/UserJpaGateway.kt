package br.com.pdpano.msusers.infra.database.gateways

import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._exceptions.InvalidUserException
import br.com.pdpano.msusers.domain._exceptions.UserNotFoundException
import br.com.pdpano.msusers.infra.database.entities.UserEntity.Companion.toDomain
import br.com.pdpano.msusers.infra.database.entities.UserEntity.Companion.toEntity
import br.com.pdpano.msusers.infra.database.repositories.UserRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class UserJpaGateway(private val repository: UserRepository) : UserGateway {

    override fun createUser(user: CreateUserDTO): Long =
        repository.save(user.toEntity()).idUser ?:
            throw InvalidUserException("User has invalid identifier")

    override fun getUserById(idUser: Long): User = repository.findById(idUser)
        .map { it.toDomain() }
        .orElseThrow { UserNotFoundException() }

    override fun existUser(email: String, taxNumber: String): Boolean =
        repository.existsByEmailOrTaxNumber(email, taxNumber)

    override fun patchUserBalance(idUser: Long, vlBalance: BigDecimal) {
        repository.findById(idUser)
            .map { it.copy(vlBalance = vlBalance) }
            .orElseThrow { InvalidUserException("Invalid user for update balance") }
            .let { repository.save(it) }
    }
}