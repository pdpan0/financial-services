package br.com.pdpano.msusers.infra.gateways


import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UserJpaGatewayTest {

    @Autowired
    private lateinit var userJdbcGateway: UserJdbcGateway

    @Test
    fun `user database gateway should be create an user`() {
        val uuid = UUID.randomUUID().toString()
        val email = "$uuid@mailinator.com"
        val user = CreateUserDTO(email,"Pedro $uuid",
            TestUtils.generateRandomCPF(),
            "teste321"
        )

        val idUser = assertDoesNotThrow { userJdbcGateway.createUser(user) }

        assertTrue(email == userJdbcGateway.getUserById(idUser).email)
    }
}