package com.scatterlab.springstudy.dao

import com.scatterlab.springstudy.model.Item
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ItemRepository : ReactiveCrudRepository<Item, String> {
    suspend fun save(item: Item): Item
}