package br.com.pdpano.msusers.infra.database.repositories

import br.com.pdpano.msusers.infra.database.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Long> {
    fun existsByEmailOrTaxNumber(email: String, taxNumber: String): Boolean
}