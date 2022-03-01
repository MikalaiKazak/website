package com.mikalaykazak.blog.dto.post

import com.fasterxml.jackson.annotation.JsonProperty
import com.mikalaykazak.blog.dto.tag.TagRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class PostUpdateRequest(
    @JsonProperty("id")
    @field:Positive
    @field:NotNull
    val id: Long,
    @JsonProperty("headline")
    @field:NotBlank
    val headline: String,
    @JsonProperty("htmlBody")
    @field:NotBlank
    val htmlBody: String,
    @JsonProperty("state")
    @field:NotBlank
    val state: String,
    @JsonProperty("userId")
    @field:Positive
    val userId: Long,
    @JsonProperty("tags")
    @field:NotNull
    val tags: List<TagRequest>,
)