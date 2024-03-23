package br.com.pdpano.msusers.infra.repositories

import br.com.pdpano.msusers.infra.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Long>