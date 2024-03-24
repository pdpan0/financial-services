package br.com.pdpano.msusers.adapters.configuration

import br.com.pdpano.msusers.adapters.response.ResponseErrorMessage
import br.com.pdpano.msusers.domain._exceptions.CreateUserException
import br.com.pdpano.msusers.domain._exceptions.UserNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception): ResponseErrorMessage<Nothing> {
        logger.error(exception.message, exception)
        return ResponseErrorMessage(
            false,
            "Internal Server Error",
            "Oops! Something went wrong. Our server encountered an unexpected error while processing your request. Please try again later. If the problem persists, feel free to contact our support team for assistance. We apologize for any inconvenience caused.",
            null
        )
    }

    @ExceptionHandler(CreateUserException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleCreateUserException(exception: CreateUserException): ResponseErrorMessage<Nothing> {
        return ResponseErrorMessage.build(exception)
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFoundException(exception: UserNotFoundException): ResponseErrorMessage<Nothing> {
        return ResponseErrorMessage.build(exception)
    }

}
