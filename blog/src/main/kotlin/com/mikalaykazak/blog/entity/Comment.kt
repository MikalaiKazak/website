package com.mikalaykazak.blog.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "comment")
@DynamicUpdate
class Comment(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,

	val userId: Long,

	val text: String,

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false, updatable = false)
	val post: Post,
) : BaseEntity()