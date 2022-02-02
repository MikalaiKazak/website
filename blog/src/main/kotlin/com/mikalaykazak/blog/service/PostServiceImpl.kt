package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.dto.PostUpdateRequest
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.State
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.repository.PostRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostServiceImpl(
	private val postRepository: PostRepository
) : PostService {

	@Transactional
	override fun updatePost(postUpdateRequest: PostUpdateRequest) {
		postRepository.save(postUpdateRequest.toEntity())
	}

	@Transactional
	override fun createPost(postCreateRequest: PostCreateRequest): PostResponse {
		val post = postCreateRequest.toEntity()
		return postRepository.save(post).toResponse()
	}

	@Transactional
	override fun deleteById(postId: Long) {
		postRepository.deleteById(postId)
	}

	override fun findById(postId: Long): PostResponse {
		return postRepository.findById(postId)
			.map(Post::toResponse)
			.orElseThrow {
				EmptyResultDataAccessException("Post with id=$postId not found", 1)
			}
	}

	override fun findAll(): List<PostResponse> {
		return postRepository.findAllByStateIsNot(State.REMOVED)
			.map(Post::toResponse)
			.toMutableList()
	}
}