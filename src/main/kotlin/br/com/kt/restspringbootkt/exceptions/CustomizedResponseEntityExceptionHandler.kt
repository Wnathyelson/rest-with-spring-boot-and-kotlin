package br.com.kt.restspringbootkt.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.Date

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ResponseException> {
        val responseException = ResponseException(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity<ResponseException>(responseException, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UnsupportedMathOperationException::class)
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ResponseException> {
        val responseException = ResponseException(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity<ResponseException>(responseException, HttpStatus.BAD_REQUEST)
    }
}