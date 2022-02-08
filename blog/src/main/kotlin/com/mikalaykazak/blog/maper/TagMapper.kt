package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.dto.tag.TagResponse
import com.mikalaykazak.blog.entity.Tag

fun Tag.toResponse() = TagResponse(
	tag = tag
)

fun TagRequest.toEntity() = Tag(
	tag = tag
)

fun List<Tag>.toResponses(): List<TagResponse> = map(Tag::toResponse)

fun List<TagRequest>.toEntities(): List<Tag> = map(TagRequest::toEntity)