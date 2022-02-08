package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.ReactionRequest
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.repository.ReactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReactionServiceImpl(
	private val reactionRepository: ReactionRepository,
) : ReactionService {

	override fun addReaction(reactionRequest: ReactionRequest) {
		reactionRepository.save(reactionRequest.toEntity())
	}
}