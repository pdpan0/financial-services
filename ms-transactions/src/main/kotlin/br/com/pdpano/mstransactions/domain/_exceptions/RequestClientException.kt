package br.com.pdpano.mstransactions.domain._exceptions

class RequestClientException(
    val client: String,
    override val cause: Throwable?
): RuntimeException("Occurs an unexpected error on client request")