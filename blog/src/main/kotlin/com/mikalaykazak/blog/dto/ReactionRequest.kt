package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class ReactionRequest(
	@JsonProperty("userId")
	@Positive
	@NotNull
	val userId: Long,
	@JsonProperty("postId")
	@Positive
	@NotNull
	val postId: Long,
	@JsonProperty("vote")
	@NotNull
	val vote: Int,
)