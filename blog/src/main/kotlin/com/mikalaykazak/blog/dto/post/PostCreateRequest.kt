package com.mikalaykazak.blog.dto.post

import com.fasterxml.jackson.annotation.JsonProperty
import com.mikalaykazak.blog.dto.tag.TagRequest
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

class PostCreateRequest(
	@JsonProperty("headline")
	@field:NotBlank
	val headline: String,
	@JsonProperty("htmlBody")
	@field:NotBlank
	val htmlBody: String,
	@JsonProperty("userId")
	@field:Positive
	val userId: Long,
	@JsonProperty("tags")
	@field:Valid
	val tags: List<TagRequest> = listOf(),
)