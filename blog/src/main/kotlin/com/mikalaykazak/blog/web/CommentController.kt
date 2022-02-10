package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse
import com.mikalaykazak.blog.entity.Comment
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.service.CommentService
import com.mikalaykazak.blog.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/posts/{postId}/comments")
class CommentController(
	private val commentService: CommentService,
	private val postService: PostService
) {

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createCommentForPost(
		@PathVariable("postId") postId: Long,
		@RequestBody @Valid commentCreateRequest: CommentCreateRequest,
	): CommentResponse {
		val post = postService.findPostByPostId(postId)
		val comment = commentCreateRequest.toEntity(post)
		val savedComment = commentService.createCommentForPost(postId, comment)
		return savedComment.toResponse()
	}
}