package com.scatterlab.springstudy.dao

import com.scatterlab.springstudy.model.Item
import io.kotest.core.spec.style.BehaviorSpec
import java.util.UUID

class ItemRepositoryTests(
    private val itemRepository: ItemRepository,
) : BehaviorSpec({
    Given("ItemRepository") {
        When("save") {
            Then("should save") {
                val item = Item(
                    id = UUID.randomUUID(),
                    name = "test",
                    price = 100,
                    stock = 100,
                    detail = "test",
                    status = Item.ItemStatus.FOR_SALE,
                )
                itemRepository.save(item)
            }
        }
    }
})