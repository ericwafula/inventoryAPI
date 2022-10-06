package tech.ericwathome.inventoryapi.controller

import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.ericwathome.inventoryapi.dto.ResponseMessage
import tech.ericwathome.inventoryapi.entity.Product
import tech.ericwathome.inventoryapi.service.InventoryService

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/inventory")
class InventoryController(private val inventoryService: InventoryService) {
    @PostMapping("add")
    fun addProduct(@RequestBody product: Product): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage("product added successfully")
        inventoryService.addProduct(product)
        return ResponseEntity(message, HttpStatus.OK)
    }

    @GetMapping
    fun allProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity(inventoryService.allProducts(), HttpStatus.OK)
    }

    @GetMapping("find/{id}")
    fun findProduct(@PathVariable("id") id: Long): ResponseEntity<Product> {
        return ResponseEntity(inventoryService.findProduct(id), HttpStatus.OK)
    }

    @DeleteMapping("delete/{id}")
    fun deleteProduct(@PathVariable("id") id: Long): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage("product deleted successfully")
        inventoryService.deleteProduct(id)
        return ResponseEntity(message, HttpStatus.OK)
    }

    @DeleteMapping("delete/all")
    fun deleteAll(): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage("all products deleted")
        inventoryService.deleteAll()
        return ResponseEntity(message, HttpStatus.OK)
    }
}