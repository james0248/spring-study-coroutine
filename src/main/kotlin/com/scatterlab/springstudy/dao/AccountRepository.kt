package com.scatterlab.springstudy.dao

import com.scatterlab.springstudy.model.Account
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface AccountRepository : CoroutineCrudRepository<Account, UUID> {
    suspend fun existsByEmail(email: String): Boolean
    suspend fun findByEmail(email: String): Account?
}