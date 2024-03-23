package br.com.pdpano.msusers.infra.gateways

import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain.UserGateway
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import br.com.pdpano.msusers.domain._exceptions.CreateUserException
import br.com.pdpano.msusers.domain._exceptions.UserNotFoundException
import br.com.pdpano.msusers.infra.gateways.UserJdbcUtils.CREATE_USER_SQL
import br.com.pdpano.msusers.infra.gateways.UserJdbcUtils.GET_USER_BY_ID_SQL
import br.com.pdpano.msusers.infra.gateways.UserJdbcUtils.UserRowMapper
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.stereotype.Repository
import java.lang.Exception

@Repository
@Primary
class UserJdbcGateway(private val jdbc: JdbcTemplate): UserGateway {

    override fun createUser(user: CreateUserDTO): Long =
        try {
            jdbc.query(
                CREATE_USER_SQL,
                ResultSetExtractor {
                    if (it.next()) it.getLong("id_user") else throw CreateUserException()
                },
                user.fullName,
                user.taxNumber,
                user.email,
                user.password,
                user.isShopkeeper
            )!!
        } catch (e: Exception) {
            throw CreateUserException(e)
        }


    override fun getUserById(idUser: Long): User {
        return jdbc.queryForObject(GET_USER_BY_ID_SQL, UserRowMapper(), idUser) ?: throw UserNotFoundException()
    }

}