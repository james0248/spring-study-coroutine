package com.scatterlab.springstudy.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import java.time.Instant
import java.time.LocalDateTime

@Suppress("UnnecessaryAbstractClass")
abstract class BaseEntity (
    @CreatedDate @Column("create_time") var createdAt: Instant? = null,
    @LastModifiedDate @Column("update_time") var updatedAt: Instant? = null,
)
