package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.ReactionRequest
import com.mikalaykazak.blog.service.ReactionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/posts/{postId}")
class ReactionController(
	private val reactionService: ReactionService,
) {

	@PostMapping("/reaction")
	@ResponseStatus(HttpStatus.OK)
	fun addReaction(@RequestBody @Valid reactionRequest: ReactionRequest) {
		reactionService.addReaction(reactionRequest)
	}
}