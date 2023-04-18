package com.scatterlab.springstudy.dto

data class UserSignupRequest(
    val name: String,
    val email: String,
    val password: String,
    val address: String,
)