package com.mikalaykazak.blog.dto.comment

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class CommentCreateRequest(

	@JsonProperty("userId")
	@field:Positive
	@field:NotNull
	val userId: Long,

	@JsonProperty("text")
	@field:NotBlank
	val text: String,
)