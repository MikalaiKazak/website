package com.mikalaykazak.blog.maper

import com.mikalaykazak.blog.dto.ReactionRequest
import com.mikalaykazak.blog.entity.Reaction
import com.mikalaykazak.blog.entity.Vote


fun ReactionRequest.toEntity() = Reaction(
	id = Reaction.ReactionId(
		userId = userId,
		postId = postId
	),
	vote = Vote.fromInt(vote)
)