package com.mikalaykazak.blog.dto.post

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class PostResponse(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("headline")
    val headline: String,
    @JsonProperty("htmlBody")
    val htmlBody: String,
    @JsonProperty("updatedAt")
    val updatedAt: LocalDateTime,
    @JsonProperty("state")
    val state: String,
    @JsonProperty("userId")
    val userId: Long
)