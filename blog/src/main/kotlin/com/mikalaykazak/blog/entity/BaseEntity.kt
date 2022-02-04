package com.mikalaykazak.blog.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity(
	@Column(name = "updated_at", nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),
)