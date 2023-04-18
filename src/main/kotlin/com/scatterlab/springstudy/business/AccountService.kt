package com.scatterlab.springstudy.business

import com.scatterlab.springstudy.dao.AccountRepository
import com.scatterlab.springstudy.dto.CreateAccountRequest
import com.scatterlab.springstudy.model.Account
import kotlinx.coroutines.reactor.mono
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AccountService(
    private val userRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
) : ReactiveUserDetailsService {
    suspend fun signup(request: CreateAccountRequest) {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalStateException("user already exists")
        }
        userRepository.save(Account.fromSignupRequest(request, passwordEncoder))
    }

    override fun findByUsername(username: String?): Mono<UserDetails> {
        return mono {
            val user = username?.let { userRepository.findByEmail(it) } ?: throw IllegalStateException("user not found")

            User.builder()
                .username(user.email)
                .password(user.password)
                .roles(user.role.name)
                .build()
        }
    }
}