package br.com.pdpano.msusers.domain

import java.math.BigDecimal
import java.time.LocalDateTime

class User(
    val email: String,
    val idUser: Long,
    val fullName: String,
    val taxNumber: String,
    val password: String,
    val vlBalance: BigDecimal = BigDecimal.ZERO,
    val isShopkeeper: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val isActive: Boolean = true
) {
//    val email: String = validateEmail(email)

//    private fun validateEmail(email: String): String {
//        require(Utils.isValidEmail(email)) {
//            "Email is invalid"
//        }
//
//        return email
//    }

    //TODO: Validar o CPF

}