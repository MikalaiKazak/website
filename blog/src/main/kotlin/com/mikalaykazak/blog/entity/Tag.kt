package com.mikalaykazak.blog.entity

import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tag")
@DynamicUpdate
class Tag(
	@Id
	@Column(name = "tag")
	val tag: String,

	@Column(name = "updated_at", nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	val posts: List<Post> = listOf(),
)