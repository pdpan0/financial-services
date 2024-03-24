package br.com.pdpano.mstransactions.infra.database.repositories

import br.com.pdpano.mstransactions.infra.database.entities.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<TransactionEntity, Long>
