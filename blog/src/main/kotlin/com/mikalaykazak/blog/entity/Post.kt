package com.mikalaykazak.blog.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "post")
class Post(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long?,

	@Column(name = "title", nullable = false)
	val title: String,

	@Column(name = "text", nullable = false)
	val text: String,

	@Column(name = "created_at", nullable = false)
	val createdAt: LocalDateTime,

	@Column(name = "updated_at", nullable = false)
	val updatedAt: LocalDateTime,

	@Column(name = "author", nullable = false)
	val author: String,
) {
	constructor(
		title: String,
		text: String,
		createdAt: LocalDateTime,
		updatedAt: LocalDateTime,
		author: String
	) : this(null, title, text, createdAt, updatedAt, author)

	enum class State(state: String) {
		HIDDEN("hidden"),
		DRAFT("draft"),
		ACTIVE("active")
	}
}