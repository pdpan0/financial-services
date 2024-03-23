package br.com.pdpano.msusers.infra.gateways

import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._exceptions.UserNotFoundException
import br.com.pdpano.msusers.infra.entities.UserEntity.Companion.toDomain
import br.com.pdpano.msusers.infra.entities.UserEntity.Companion.toEntity
import br.com.pdpano.msusers.infra.repositories.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserJpaGateway(private val repository: UserRepository) : UserGateway {

    override fun createUser(user: CreateUserDTO): Long =
        repository.save(user.toEntity()).idUser ?:
            throw IllegalArgumentException("User has invalid identifier")

    override fun getUserById(idUser: Long): User = repository.findById(idUser)
        .map { it.toDomain() }
        .orElseThrow { UserNotFoundException() }

}