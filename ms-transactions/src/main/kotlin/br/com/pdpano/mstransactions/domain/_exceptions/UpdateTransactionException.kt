package br.com.pdpano.mstransactions.domain._exceptions

class UpdateTransactionException(
    override val message: String? = "Unable to update transaction",
    override val cause: Throwable? = null
): RuntimeException()