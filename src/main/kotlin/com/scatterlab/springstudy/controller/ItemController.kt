package com.scatterlab.springstudy.controller

import com.scatterlab.springstudy.business.ItemService
import com.scatterlab.springstudy.dto.ItemDto
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/items")
@RestController
class ItemController(
    private val itemService: ItemService
) {
    @GetMapping
    suspend fun findAll(): Flow<ItemDto> = itemService.findAll()
}