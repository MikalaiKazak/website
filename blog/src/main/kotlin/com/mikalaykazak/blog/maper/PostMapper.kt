package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.dto.PostUpdateRequest
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.State

fun PostCreateRequest.toEntity() = Post(
	headline = headline,
	markdownBody = markdownBody,
	state = State.DRAFT,
	authorId = authorId,
	tags = tags.toEntities()
)

fun PostUpdateRequest.toEntity() = Post(
	id = id,
	headline = headline,
	markdownBody = markdownBody,
	state = State.valueOf(state),
	authorId = authorId,
	tags = tags.toEntities()
)

fun Post.toResponse() = PostResponse(
	id = id!!,
	headline = headline,
	markdownBody = markdownBody,
	htmlBody = htmlBody,
	authorId = authorId,
	updatedAt = updatedAt,
	state = state.name,
	tags = tags.toResponses()
)

fun List<Post>.toResponses(): List<PostResponse> = map(Post::toResponse)