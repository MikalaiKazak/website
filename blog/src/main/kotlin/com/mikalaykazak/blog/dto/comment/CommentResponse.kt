package com.mikalaykazak.blog.dto.comment

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class CommentResponse(
	@JsonProperty("id")
	val id: Long,

	@JsonProperty("userId")
	val userId: Long,

	@JsonProperty("text")
	val text: String,
)