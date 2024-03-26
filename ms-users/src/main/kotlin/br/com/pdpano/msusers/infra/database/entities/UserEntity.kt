package br.com.pdpano.msusers.infra.database.entities

import br.com.pdpano.msusers.domain.User
import br.com.pdpano.msusers.domain._dto.CreateUserDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "tb_users")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUser: Long?,
    val fullName: String,
    val email: String,
    val taxNumber: String,
    val password: String,
    val vlBalance: BigDecimal = BigDecimal.ZERO,
    val isShopkeeper: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val isActive: Boolean = true
) {
    companion object {
        fun CreateUserDTO.toEntity(): UserEntity {
            return UserEntity(
                idUser = null,
                fullName = fullName,
                email = email,
                taxNumber = taxNumber,
                password = password,
                isShopkeeper = isShopkeeper,
                vlBalance = vlBalance
            )
        }

        fun UserEntity.toDomain() = User(
            email,
            idUser ?: throw IllegalArgumentException("User has invalid identifier"),
            fullName,
            taxNumber,
            password,
            vlBalance,
            isShopkeeper,
            createdAt,
            isActive
        )
    }
}