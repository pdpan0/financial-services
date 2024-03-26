package br.com.pdpano.msusers.usecase.createuser

import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._exceptions.CreateUserException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CreateUserUseCaseImpl(private val gateway: UserGateway): CreateUserUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(input: CreateUserDTO): Long {
        if (gateway.existUser(input.email, input.taxNumber)) {
            logger.debug("User already exists {}", input)
            throw CreateUserException("User already exists")
        }

        if (input.vlBalance < BigDecimal.ZERO) {
            logger.debug("User cannot be created with negative balance {}", input)
            throw CreateUserException("User cannot be created with negative balance")
        }

        return gateway.createUser(input)
    }
}