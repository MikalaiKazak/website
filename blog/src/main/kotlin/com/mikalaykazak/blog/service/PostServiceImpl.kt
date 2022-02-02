package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.repository.PostRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class PostServiceImpl(
	private val postRepository: PostRepository
) : PostService {

	@Transactional
	override fun createPost(postCreateRequest: PostCreateRequest): PostResponse {
		val post = postRepository.save(toEntity(postCreateRequest))
		return toResponse(post)
	}

	private fun toEntity(postCreateRequest: PostCreateRequest) =
		Post(
			title = postCreateRequest.title,
			text = postCreateRequest.text,
			createdAt = LocalDateTime.now(),
			updatedAt = LocalDateTime.now(),
			author = postCreateRequest.author
		)

	override fun findAll(): List<PostResponse> {
		return postRepository.findAll()
			.map(::toResponse)
			.toList()
	}

	private fun toResponse(post: Post) = PostResponse(
		id = post.id!!,
		title = post.title,
		text = post.text,
		createdAt = post.createdAt,
		updatedAt = post.updatedAt,
		author = post.author
	)
}