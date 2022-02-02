package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostUpdateRequest(
	@JsonProperty("id")
	@field:Positive
	val id: Long,
	@JsonProperty("title")
	@field:NotBlank
	val title: String,
	@JsonProperty("text")
	@field:NotBlank
	val text: String,
	@JsonProperty("state")
	@field:NotBlank
	val state: String,
	@JsonProperty("authorId")
	@field:Positive
	val authorId: Long,
)