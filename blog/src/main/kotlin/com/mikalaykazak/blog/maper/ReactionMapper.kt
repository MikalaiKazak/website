package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.reaction.ReactionRequest
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.Reaction


fun ReactionRequest.toEntity(post: Post) = Reaction(
	id = Reaction.ReactionId(
		userId = userId,
		postId = post.id!!
	),
	post = post,
	isLiked = isLiked
)