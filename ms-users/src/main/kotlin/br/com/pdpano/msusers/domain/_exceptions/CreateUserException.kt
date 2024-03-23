package br.com.pdpano.msusers.domain._exceptions

class CreateUserException(override val cause: Throwable? = null): RuntimeException("Unable to register user")