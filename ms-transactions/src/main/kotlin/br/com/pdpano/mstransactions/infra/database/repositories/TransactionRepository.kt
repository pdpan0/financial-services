package br.com.pdpano.mstransactions.infra.database.repositories

import br.com.pdpano.mstransactions.domain.transactions.TransactionStatus
import br.com.pdpano.mstransactions.infra.database.entities.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface TransactionRepository: JpaRepository<TransactionEntity, Long> {

    @Transactional
    @Modifying
    @Query("update tb_transactions set status = :status where idTransaction = :id")
    fun updateStatusByIdTransaction(@Param("id") idTransaction: Long, @Param("status") status: TransactionStatus)

}
