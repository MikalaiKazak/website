package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostResponse(
	@JsonProperty("id")
	val id: Long,
	@JsonProperty("headline")
	val headline: String,
	@JsonProperty("markdownBody")
	val markdownBody: String,
	@JsonProperty("htmlBody")
	val htmlBody: String,
	@JsonProperty("updatedAt")
	val updatedAt: LocalDateTime,
	@JsonProperty("state")
	val state: String,
	@JsonProperty("authorId")
	val authorId: Long,

	@JsonProperty("tags")
	val tags: List<TagResponse>,
)