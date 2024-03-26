package br.com.pdpano.mstransactions.adapters.configuration

import br.com.pdpano.mstransactions.domain._exceptions.CreateTransactionException
import br.com.pdpano.mstransactions.domain._exceptions.RequestClientException
import br.com.pdpano.mstransactions.domain._response.ResponseErrorMessage
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

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleRequestClientException(exception: RequestClientException): ResponseErrorMessage<String> {
        return ResponseErrorMessage.build(exception, exception.client)
    }

    @ExceptionHandler(CreateTransactionException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleCreateUserException(exception: CreateTransactionException): ResponseErrorMessage<Nothing> {
        return ResponseErrorMessage.build(exception)
    }

}
