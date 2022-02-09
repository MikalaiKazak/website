package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CommentService {
	fun createCommentForPost(
		postId: Long,
		comment: Comment,
	): Comment

	fun findAllCommentsByPostId(postId: Long, pageable: Pageable): Page<Comment>
}