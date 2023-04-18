package com.scatterlab.springstudy.dto

data class CreateAccountRequest(
    val name: String,
    val email: String,
    val password: String,
    val address: String,
)