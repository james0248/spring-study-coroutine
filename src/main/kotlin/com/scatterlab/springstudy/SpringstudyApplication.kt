package com.scatterlab.springstudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [R2dbcAutoConfiguration::class])
class SpringstudyApplication

fun main(args: Array<String>) {
    runApplication<SpringstudyApplication>(*args)
}
