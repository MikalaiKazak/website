package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse
import com.mikalaykazak.blog.entity.Comment
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.repository.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
	private val commentRepository: CommentRepository,
	private val postService: PostService,
) : CommentService {

	override fun findAllByPostId(postId: Long) = commentRepository.findAllByPostId(postId)
		.map(Comment::toResponse)
		.toList()

	override fun createCommentForPost(
		postId: Long,
		commentCreateRequest: CommentCreateRequest,
	): CommentResponse {
		val post = postService.findEntityById(postId)
		val comment = commentCreateRequest.toEntity(post)
		return commentRepository.save(comment).toResponse()
	}
}