package com.scatterlab.springstudy.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("items")
class Item(
    @Id val id: UUID,
    @Column(value = "name") val name: String,
    @Column(value = "price") val price: Int,
    @Column(value = "stock") val stock: Int,
    @Column(value = "detail") val detail: String,
    @Column(value = "status") val status: ItemStatus,
): BaseEntity() {
    enum class ItemStatus {
        FOR_SALE, SOLD_OUT
    }
}
