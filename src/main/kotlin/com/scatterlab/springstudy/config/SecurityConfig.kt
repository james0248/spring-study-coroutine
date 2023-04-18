package com.scatterlab.springstudy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.pathMatchers

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http {
            formLogin {
                loginPage = "/users/login"
                authenticationSuccessHandler = RedirectServerAuthenticationSuccessHandler("/")
            }
            authorizeExchange {
                authorize(pathMatchers("/users/login", "/users", "/users/**"), permitAll)
                authorize(pathMatchers("/admin/**"), hasRole("ADMIN"))
                authorize(anyExchange, authenticated)
            }
            exceptionHandling { }
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}