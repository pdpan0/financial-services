package br.com.pdpano.msusers.domain

import br.com.pdpano.msusers.domain._dto.CreateUserDTO

/**
 * UserGateway defines CRUD methods used by usecases
 */
interface UserGateway {
    fun createUser(user: CreateUserDTO): Long
    fun getUserById(idUser: Long): User
    fun existUser(email: String, taxNumber: String): Boolean
}