package br.com.pdpano.mstransactions.domain.transactions

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val idTransaction: Long,
    val idPayer: Long,
    val idPayee: Long,
    val status: TransactionStatus = TransactionStatus.PENDING,
    val vlTransaction: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now()
    //TODO: add ip
)