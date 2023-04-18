package com.scatterlab.springstudy.dao

import com.scatterlab.springstudy.model.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface UserRepository : CoroutineCrudRepository<User, UUID> {
    suspend fun existsByEmail(email: String): Boolean
}