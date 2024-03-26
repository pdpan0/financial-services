package br.com.pdpano.mstransactions.domain._dto

import java.math.BigDecimal

data class TransferBalanceDTO(
    val idTransaction: Long,
    val idPayer: Long,
    val idPayee: Long,
    val vlTransaction: BigDecimal,
)