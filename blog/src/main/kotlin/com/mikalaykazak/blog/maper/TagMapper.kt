package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.TagRequest
import com.mikalaykazak.blog.dto.TagResponse
import com.mikalaykazak.blog.entity.Tag

fun Tag.toResponse() = TagResponse(
	tag = id
)

fun TagRequest.toEntity() = Tag(
	id = tag
)

fun List<Tag>.toResponses(): List<TagResponse> = map(Tag::toResponse)

fun List<TagRequest>.toEntities(): List<Tag> = map(TagRequest::toEntity)