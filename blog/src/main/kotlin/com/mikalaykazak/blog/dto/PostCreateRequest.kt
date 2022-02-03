package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostCreateRequest(
	@JsonProperty("headline")
	@field:NotBlank
	val headline: String,
	@JsonProperty("markdownBody")
	@field:NotBlank
	val markdownBody: String,
	@JsonProperty("authorId")
	@field:Positive
	val authorId: Long,
	@JsonProperty("tags")
	@field:Valid
	val tags: List<TagRequest> = listOf(),
)