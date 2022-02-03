package com.mikalaykazak.blog.entity

import java.time.LocalDateTime

class Job(
	id: Long = 0,
	val postId: Long,
	val publishedAt: LocalDateTime,
)