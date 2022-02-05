package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post/{postId}/comment")
class CommentController(
	private val commentService: CommentService,
) {
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun getAllByPostId(@PathVariable("postId") postId: Long) =
		commentService.findAllByPostId(postId)

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createCommentForPost(
		@PathVariable("postId") postId: Long,
		@RequestBody @Valid commentCreateRequest: CommentCreateRequest,
	) = commentService.createCommentForPost(postId, commentCreateRequest)
}