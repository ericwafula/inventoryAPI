package tech.ericwathome.inventoryapi.error

import org.springframework.http.HttpStatus

data class ErrorMessage(
    val message: String,
    val status: HttpStatus
)