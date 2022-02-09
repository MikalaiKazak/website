package com.mikalaykazak.blog.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ResponseWithPage<T>(
	@JsonProperty("data")
	val data: T,

	@JsonProperty("currentPage")
	val currentPage: Int,
	@JsonProperty("totalPages")
	val totalPages: Int,
	@JsonProperty("totalElements")
	val totalElements: Long,
)