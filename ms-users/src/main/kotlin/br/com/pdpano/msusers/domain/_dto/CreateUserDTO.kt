package br.com.pdpano.msusers.domain._dto

data class CreateUserDTO(
    val email: String,
    val fullName: String,
    val taxNumber: String,
    val password: String,
    val isShopkeeper: Boolean = false,
)