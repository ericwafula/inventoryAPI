package tech.ericwathome.inventoryapi.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Product (
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id val id: Long? = null,
    val sku: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Int,
    val quantity: Int
)