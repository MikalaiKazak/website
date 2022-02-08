package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Comment

interface CommentService {
	fun createCommentForPost(
		postId: Long,
		comment: Comment,
	): Comment

	fun findAllByPostId(postId: Long): List<Comment>
}