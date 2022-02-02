package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostResponse(
	@JsonProperty("id")
	val id: Long,
	@JsonProperty("title")
	val title: String,
	@JsonProperty("text")
	val text: String,
	@JsonProperty("createdAt")
	val createdAt: LocalDateTime,
	@JsonProperty("updatedAt")
	val updatedAt: LocalDateTime,
	@JsonProperty("author")
	val author: String
)