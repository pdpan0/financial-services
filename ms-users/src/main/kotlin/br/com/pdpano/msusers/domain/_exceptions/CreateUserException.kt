package br.com.pdpano.msusers.domain._exceptions

class CreateUserException(
    override val message: String? = "Unable to register user",
    override val cause: Throwable? = null
): RuntimeException() {
    constructor(cause: Throwable?): this(null, cause)
}