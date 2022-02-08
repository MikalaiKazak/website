package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.ReactionRequest

interface ReactionService {
	fun addReaction(postId: Long, reactionRequest: ReactionRequest)
}