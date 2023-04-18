package com.scatterlab.springstudy.model

import com.scatterlab.springstudy.dto.UserSignupRequest
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.UUID

@Table("users")
class User(
    val id: UUID,
    val name: String,
    val email: String,
    val password: String,
    val address: String,
    val role: Role,
) {
    companion object {
        fun fromSignupRequest(dto: UserSignupRequest, passwordEncoder: PasswordEncoder) = User(
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