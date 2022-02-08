package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Reaction

interface ReactionService {
	fun addReaction(postId: Long, reaction: Reaction)
}