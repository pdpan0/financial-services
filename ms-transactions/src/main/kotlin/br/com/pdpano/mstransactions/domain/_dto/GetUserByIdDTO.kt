package br.com.pdpano.mstransactions.domain._dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class GetUserByIdDTO(
    val idUser: Long,
    val fullName: String,
    val email: String,
    val taxNumber: String,
    val vlBalance: BigDecimal = BigDecimal.ZERO,
    val isShopkeeper: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val isActive: Boolean = true
)