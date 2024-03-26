package br.com.pdpano.mstransactions.domain.transactions

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO

interface TransactionGateway {
    fun createTransaction(transaction: CreateTransactionDTO): Long
    fun updateStatus(idTransaction: Long, status: TransactionStatus)
    fun getTransactionById(idTransaction: Long): Transaction
}