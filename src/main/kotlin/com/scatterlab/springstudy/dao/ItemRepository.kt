package com.scatterlab.springstudy.dao

import com.scatterlab.springstudy.model.Item
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface ItemRepository : CoroutineCrudRepository<Item, UUID> {
    suspend fun save(item: Item): Item
    suspend fun findByName(name: String): List<Item>
    suspend fun findByNameOrDetail(name: String, detail: String): List<Item>
    suspend fun findByPriceLessThan(price: Int): List<Item>
    suspend fun findByPriceLessThanOrderByPriceDesc(price: Int): List<Item>

    @Query("SELECT * FROM items WHERE detail LIKE :detail")
    suspend fun findByDetailLike(detail: String): List<Item>
}
