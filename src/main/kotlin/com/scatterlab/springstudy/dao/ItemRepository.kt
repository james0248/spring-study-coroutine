package com.scatterlab.springstudy.dao

import com.scatterlab.springstudy.model.Item
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface ItemRepository : ReactiveCrudRepository<Item, UUID> {
    suspend fun save(item: Item): Item
}
