package com.scatterlab.springstudy.dto

import com.scatterlab.springstudy.model.Item
import java.util.UUID

data class ItemDto(
    val id: UUID,
    val name: String,
    val price: Int,
    val stock: Int,
    val detail: String,
    val status: Item.ItemStatus,
) {
    companion object {
        fun from(item: Item) = ItemDto(
            id = item.id,
            name = item.name,
            price = item.price,
            stock = item.stock,
            detail = item.detail,
            status = item.status,
        )
    }
}
