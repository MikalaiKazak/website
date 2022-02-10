package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Comment
import com.mikalaykazak.blog.repository.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
	private val commentRepository: CommentRepository,
) : CommentService {

	@Transactional(readOnly = true)
	override fun findAllCommentsByPostId(
		postId: Long,
	): Set<Comment> {
		return commentRepository.findAllByPostId(postId)
	}

	@Transactional
	override fun createCommentForPost(postId: Long, comment: Comment): Comment {
		return commentRepository.save(comment)
	}
}