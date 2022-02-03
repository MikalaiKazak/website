package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostUpdateRequest(
	@JsonProperty("id")
	@field:Positive
	@field:NotNull
	val id: Long,
	@JsonProperty("headline")
	@field:NotBlank
	val headline: String,
	@JsonProperty("markdownBody")
	@field:NotBlank
	val markdownBody: String,
	@JsonProperty("state")
	@field:NotBlank
	val state: String,
	@JsonProperty("authorId")
	@field:Positive
	val authorId: Long,
	@JsonProperty("tags")
	@field:NotNull
	val tags: List<TagRequest>,
)