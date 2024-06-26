package br.com.pdpano.mstransactions.infra.database.entities

import br.com.pdpano.mstransactions.domain.transactions.TransactionStatus
import br.com.pdpano.mstransactions.domain._dto.CreateTransactionDTO
import br.com.pdpano.mstransactions.domain.transactions.Transaction
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "tb_transactions")
data class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idTransaction: Long?,
    val idPayer: Long,
    val idPayee: Long,
    @Enumerated(EnumType.STRING)
    val status: TransactionStatus = TransactionStatus.PENDING,
    val vlTransaction: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun CreateTransactionDTO.toEntity() = TransactionEntity(
            idTransaction = null,
            idPayer = idPayer,
            idPayee = idPayee,
            vlTransaction = vlTransaction
        )

        fun TransactionEntity.toDomain() = Transaction(
            idTransaction = idTransaction!!,
            idPayer = idPayer,
            idPayee = idPayee,
            status = status,
            vlTransaction = vlTransaction
        )
    }
}