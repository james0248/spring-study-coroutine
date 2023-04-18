package com.scatterlab.springstudy.model

import com.scatterlab.springstudy.dto.CreateAccountRequest
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.UUID

@Table("accounts")
class Account(
    val id: UUID,
    val name: String,
    val email: String,
    val password: String,
    val address: String,
    val role: Role,
) {
    companion object {
        fun fromSignupRequest(dto: CreateAccountRequest, passwordEncoder: PasswordEncoder) = Account(
            id = UUID.randomUUID(),
            name = dto.name,
            email = dto.email,
            password = passwordEncoder.encode(dto.password),
            address = dto.address,
            role = Role.USER,
        )
    }

    enum class Role {
        USER, ADMIN
    }
}