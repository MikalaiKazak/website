package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostResponse
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.State

fun PostCreateRequest.toEntity() = Post(
    headline = headline,
    htmlBody = htmlBody,
    state = State.PUBLISHED,
    userId = userId,
    tags = tags.toEntities()
)

fun PostUpdateRequest.toEntity() = Post(
    id = id,
    headline = headline,
    htmlBody = htmlBody,
    state = State.valueOf(state),
    userId = userId,
    tags = tags.toEntities()
)

fun Post.toResponse() = PostResponse(
	id = id!!,
	headline = headline,
	htmlBody = htmlBody,
	userId = userId,
	updatedAt = updatedAt,
    state = state.name
)

fun List<Post>.toResponses(): List<PostResponse> = map(Post::toResponse)