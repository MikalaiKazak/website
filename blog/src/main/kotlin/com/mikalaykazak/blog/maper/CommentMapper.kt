package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse
import com.mikalaykazak.blog.entity.Comment
import com.mikalaykazak.blog.entity.Post

fun Comment.toResponse() = CommentResponse(
	id = id!!,
	userId = userId,
	text = text
)

fun List<Comment>.toResponses() = map(Comment::toResponse)

fun CommentCreateRequest.toEntity(post: Post) = Comment(
	userId = userId,
	text = text,
	post = post
)