package tech.ericwathome.inventoryapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.ericwathome.inventoryapi.entity.Product

@Repository
interface InventoryRepository : JpaRepository<Product, Long> {
}