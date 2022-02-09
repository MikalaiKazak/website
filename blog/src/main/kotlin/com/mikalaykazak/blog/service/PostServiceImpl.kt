package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.repository.PostRepository
import com.vladsch.flexmark.ext.escaped.character.EscapedCharacterExtension
import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.parser.PegdownExtensions
import com.vladsch.flexmark.profile.pegdown.PegdownOptionsAdapter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class PostServiceImpl(
	private val postRepository: PostRepository,
) : PostService {

	@Transactional
	override fun updatePost(post: Post): Post {
		return when {
			isPostExistsByPostId(post.id!!) -> {
				processMarkdownToHtml(post)
				postRepository.save(post)
			}
			else -> throw EntityNotFoundException("Post with id=${post.id} not found")
		}
	}

	@Transactional(readOnly = true)
	override fun isPostExistsByPostId(postId: Long): Boolean {
		return postRepository.existsById(postId)
	}

	@Transactional
	override fun createPost(post: Post): Post {
		processMarkdownToHtml(post)
		return postRepository.save(post)
	}

	@Transactional
	override fun deletePostByPostId(postId: Long) {
		return when {
			isPostExistsByPostId(postId) -> postRepository.deleteById(postId)
			else -> throw EntityNotFoundException("Post with id=$postId not found")
		}
	}

	@Transactional(readOnly = true)
	override fun findAllPosts(pageable: Pageable): Page<Post> {
		return postRepository.findAll(pageable)
	}

	@Transactional(readOnly = true)
	override fun findPostByPostId(postId: Long): Post {
		return postRepository.findById(postId)
			.orElseThrow { EntityNotFoundException("Post with id=$postId not found") }
	}

	@Transactional(readOnly = true)
	override fun findAllPostsByTag(tag: String, pageable: Pageable): Page<Post> {
		return postRepository.findAllByTags_Tag(tag, pageable)
	}

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