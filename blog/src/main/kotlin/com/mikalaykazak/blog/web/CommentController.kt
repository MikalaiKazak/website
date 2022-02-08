package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse
import com.mikalaykazak.blog.service.CommentService
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
) {

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun getAllByPostId(
		@PathVariable("postId") postId: Long,
		@RequestParam("page", defaultValue = "0") page: Int,
		@RequestParam("limit", defaultValue = "10") limit: Int,
		@RequestParam("sortBy", defaultValue = "updatedAt") sortBy: String,
		@RequestParam("orderBy", defaultValue = "desc") orderBy: String,
	): List<CommentResponse> {
		return commentService.findAllByPostId(postId)
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createCommentForPost(
		@PathVariable("postId") postId: Long,
		@RequestBody @Valid commentCreateRequest: CommentCreateRequest,
	) = commentService.createCommentForPost(postId, commentCreateRequest)
}