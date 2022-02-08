package com.mikalaykazak.blog.dto.reaction

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class ReactionRequest(
	@JsonProperty("userId")
	@Positive
	@NotNull
	val userId: Long,

	@JsonProperty("vote")
	@NotNull
	val vote: Int,
)