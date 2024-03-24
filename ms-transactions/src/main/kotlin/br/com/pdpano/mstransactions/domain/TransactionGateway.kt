package br.com.pdpano.mstransactions.domain

import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO

interface TransactionGateway {
    fun createTransaction(transaction: CreateTransactionDTO): Long
}