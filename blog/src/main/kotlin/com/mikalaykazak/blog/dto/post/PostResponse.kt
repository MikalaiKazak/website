package com.mikalaykazak.blog.dto.post

import com.fasterxml.jackson.annotation.JsonProperty
import com.mikalaykazak.blog.dto.tag.TagResponse
import java.time.LocalDateTime

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
	@JsonProperty("userId")
	val userId: Long,

	@JsonProperty("tags")
	val tags: List<TagResponse>,
)