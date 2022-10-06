package tech.ericwathome.inventoryapi.service

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import tech.ericwathome.inventoryapi.entity.Product
import tech.ericwathome.inventoryapi.error.ProductNotFoundException
import tech.ericwathome.inventoryapi.repository.InventoryRepository

@RequiredArgsConstructor
@Service
class InventoryServiceImpl(private val repository: InventoryRepository): InventoryService {
    override fun addProduct(product: Product) {
        repository.save(product)
    }

    override fun allProducts(): List<Product> {
        return repository.findAll()
    }

    override fun findProduct(id: Long): Product {
        return try {
            repository.findById(id).get()
        } catch (e: Exception) {
            throw ProductNotFoundException("no product found with id: $id")
        }
    }

    override fun deleteProduct(id: Long) {
        try {
            repository.deleteById(id)
        } catch (e: Exception) {
            throw ProductNotFoundException("no product found with id: $id")
        }
    }

    override fun deleteAll() {
        repository.deleteAll()
    }

}