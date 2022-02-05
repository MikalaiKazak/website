package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostResponse
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.maper.toResponses
import com.mikalaykazak.blog.repository.PostRepository
import com.vladsch.flexmark.ext.escaped.character.EscapedCharacterExtension
import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.parser.PegdownExtensions
import com.vladsch.flexmark.profile.pegdown.PegdownOptionsAdapter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
@Transactional
class PostServiceImpl(
	private val postRepository: PostRepository,
	private val tagService: TagService,
) : PostService {

	override fun updatePost(postUpdateRequest: PostUpdateRequest) = when {
		existsById(postUpdateRequest.id) -> {
			val post = postUpdateRequest.toEntity()
			processMarkdownToHtml(post)
			postRepository.save(post).toResponse()
		}
		else -> throw EntityNotFoundException("Post with id=${postUpdateRequest.id} not found")
	}

	override fun existsById(postId: Long) = postRepository.existsById(postId)

	override fun createPost(postCreateRequest: PostCreateRequest): PostResponse {
		val post = postCreateRequest.toEntity()
		processMarkdownToHtml(post)
		return postRepository.save(post).toResponse()
	}

	override fun deleteById(postId: Long) = when {
		existsById(postId) -> postRepository.deleteById(postId)
		else -> throw EntityNotFoundException("Post with id=$postId not found")
	}

	override fun findById(postId: Long) = findEntityById(postId).toResponse()

	override fun findAll(): List<PostResponse> = postRepository.findAll().toResponses()

	override fun findEntityById(postId: Long) = postRepository.findById(postId)
		.orElseThrow { EntityNotFoundException("Post with id=$postId not found") }

	//TODO
	private fun processMarkdownToHtml(post: Post): Post {
		val options = PegdownOptionsAdapter.flexmarkOptions(true,
			PegdownExtensions.HARDWRAPS,
			TablesExtension.create(),
			EscapedCharacterExtension.create())

		val parser = Parser.builder(options).build()
		val document = parser.parse(post.markdownBody)

		val renderer = HtmlRenderer.builder(options).build()
		post.htmlBody = renderer.render(document)

		return post
	}
}