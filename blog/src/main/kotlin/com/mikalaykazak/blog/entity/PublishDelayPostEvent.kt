package com.mikalaykazak.blog.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

//TODO change name
@Entity
@Table(name = "publish_delay_post_event")
class PublishDelayPostEvent(

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,

	@Column(name = "post_id", nullable = false)
	val postId: Long,

	@Column(name = "publish_at", nullable = false)
	val publishAt: LocalDateTime
)