package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.dto.PostUpdateRequest
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
class PostServiceImpl(
	private val postRepository: PostRepository,
	private val tagService: TagService,
) : PostService {

	@Transactional
	override fun updatePost(postUpdateRequest: PostUpdateRequest): PostResponse =
		postRepository.findById(postUpdateRequest.id)
			.map { postUpdateRequest.toEntity() }
			.map(::processMarkdownToHtml)
			.map(postRepository::save)
			.map(Post::toResponse)
			.orElseThrow { throw EntityNotFoundException("Post with id=${postUpdateRequest.id} not found") }

	@Transactional
	override fun createPost(postCreateRequest: PostCreateRequest): PostResponse {
		val post = postCreateRequest.toEntity()
		processMarkdownToHtml(post)
		return postRepository.save(post).toResponse()
	}

	@Transactional
	override fun deleteById(postId: Long) = when {
		postRepository.existsById(postId) -> {
			postRepository.softDelete(postId)
		} else -> {
			throw EntityNotFoundException("Post with id=$postId not found")
		}
	}

	@Transactional(readOnly = true)
	override fun findById(postId: Long): PostResponse =
		postRepository.findById(postId)
			.map(Post::toResponse)
			.orElseThrow { EntityNotFoundException("Post with id=$postId not found") }

	@Transactional(readOnly = true)
	override fun findAll(): List<PostResponse> = postRepository.findAll().toResponses()

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