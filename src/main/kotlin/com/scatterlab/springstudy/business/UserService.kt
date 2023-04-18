package com.scatterlab.springstudy.business

import com.scatterlab.springstudy.dao.UserRepository
import com.scatterlab.springstudy.dto.UserSignupRequest
import com.scatterlab.springstudy.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    suspend fun signup(request: UserSignupRequest) {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalStateException("user already exists")
        }
        userRepository.save(User.fromSignupRequest(request, passwordEncoder))
    }
}