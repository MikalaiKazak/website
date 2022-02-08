package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.reaction.ReactionRequest
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.service.PostService
import com.mikalaykazak.blog.service.ReactionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/posts/{postId}/reaction")
class ReactionController(
	private val reactionService: ReactionService,
	private val postService: PostService,
) {

	@PostMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun addReaction(
		@PathVariable("postId") postId: Long,
		@RequestBody @Valid reactionRequest: ReactionRequest,
	) {
		val post = postService.findById(postId)
		val reaction = reactionRequest.toEntity(post)
		reactionService.addReaction(postId, reaction)
	}
}