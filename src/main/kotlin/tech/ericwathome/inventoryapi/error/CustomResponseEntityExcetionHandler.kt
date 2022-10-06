package tech.ericwathome.inventoryapi.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@ResponseStatus
class CustomResponseEntityExcetionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(ProductNotFoundException::class)
    fun productNotFoundException(exception: ProductNotFoundException, request: WebRequest): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(exception.message!!, HttpStatus.NOT_FOUND)
        return ResponseEntity(message, HttpStatus.NOT_FOUND)
    }
}