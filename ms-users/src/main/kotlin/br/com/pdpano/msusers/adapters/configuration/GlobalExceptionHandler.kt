package br.com.pdpano.msusers.adapters.configuration

import br.com.pdpano.msusers.adapters.response.ResponseErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception): ResponseErrorMessage<Nothing> {
        return ResponseErrorMessage.build(exception)
    }

}
