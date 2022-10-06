package tech.ericwathome.inventoryapi.service

import tech.ericwathome.inventoryapi.entity.Product

interface InventoryService {
    fun addProduct(product: Product)
    fun allProducts(): List<Product>
    fun findProduct(id: Long): Product
    fun deleteProduct(id: Long)
    fun deleteAll()
}