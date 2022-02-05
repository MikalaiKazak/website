package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse

interface CommentService {
	fun findAllByPostId(postId: Long): List<CommentResponse>
	fun createCommentForPost(
		postId: Long,
		commentCreateRequest: CommentCreateRequest,
	): CommentResponse
}