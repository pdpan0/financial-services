package br.com.pdpano.mstransactions.domain._dto

import br.com.pdpano.mstransactions.domain.transactions.TransactionStatus

data class UpdateTransactionDTO(
    val idTransaction: Long,
    val status: TransactionStatus
)
