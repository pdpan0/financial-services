package br.com.pdpano.mstransactions.domain._exceptions

class CreateTransactionException(
    override val message: String? = "Unable to register transaction",
    override val cause: Throwable? = null
): RuntimeException()