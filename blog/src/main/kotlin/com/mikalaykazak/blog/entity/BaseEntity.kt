package com.mikalaykazak.blog.entity

import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
@DynamicUpdate
open class BaseEntity(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,
) {
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	lateinit var updatedAt: LocalDateTime
}