package com.mikalaykazak.blog.dto.tag

import com.fasterxml.jackson.annotation.JsonProperty

class TagResponse(
	@JsonProperty("tag")
	val tag: String,
)