package br.com.pdpano.mstransactions.infra.database.gateways

import br.com.pdpano.mstransactions.domain.transactions.TransactionGateway
import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain._exceptions.CreateTransactionException
import br.com.pdpano.mstransactions.infra.database.entities.TransactionEntity.Companion.toEntity
import br.com.pdpano.mstransactions.infra.database.repositories.TransactionRepository
import org.springframework.stereotype.Repository

@Repository
class TransactionJpaGateway(private val repository: TransactionRepository): TransactionGateway {

    override fun createTransaction(transaction: CreateTransactionDTO): Long =
        repository.save(transaction.toEntity()).idTransaction ?: throw CreateTransactionException()
}