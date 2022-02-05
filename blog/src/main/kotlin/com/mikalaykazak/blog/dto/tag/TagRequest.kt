package com.mikalaykazak.blog.dto.tag

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

class TagRequest(
	@JsonProperty("tag")
	@field:NotBlank
	val tag: String,
)