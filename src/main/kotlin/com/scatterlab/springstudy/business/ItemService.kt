package com.scatterlab.springstudy.business

import com.scatterlab.springstudy.dao.ItemRepository
import com.scatterlab.springstudy.dto.ItemDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {
    suspend fun findAll(): Flow<ItemDto> {
        return itemRepository.findAll().map { ItemDto.from(it) }
    }
}