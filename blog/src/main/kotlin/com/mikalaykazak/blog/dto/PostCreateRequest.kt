package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostCreateRequest(
	@JsonProperty("title")
	@field:NotBlank
	val title: String,
	@JsonProperty("text")
	@field:NotBlank
	val text: String,
	@JsonProperty("author")
	@field:NotBlank
	val author: String
)