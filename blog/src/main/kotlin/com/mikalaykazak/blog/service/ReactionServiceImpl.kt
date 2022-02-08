package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Reaction
import com.mikalaykazak.blog.repository.ReactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReactionServiceImpl(
	private val reactionRepository: ReactionRepository,
) : ReactionService {

	override fun addReaction(postId: Long, reaction: Reaction) {
		reactionRepository.save(reaction)
	}
}