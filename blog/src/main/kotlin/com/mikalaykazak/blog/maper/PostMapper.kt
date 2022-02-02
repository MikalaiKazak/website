package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.dto.PostUpdateRequest
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.State

fun PostCreateRequest.toEntity() = Post(
	title = title,
	text = text,
	state = State.DRAFT,
	authorId = authorId
)

fun PostUpdateRequest.toEntity() = Post(
	id = id,
	title = title,
	text = text,
	state = State.valueOf(state),
	authorId = authorId
)

fun Post.toResponse() = PostResponse(
	id = id,
	title = title,
	text = text,
	authorId = authorId,
	updatedAt = updatedAt,
	state = state.name
)