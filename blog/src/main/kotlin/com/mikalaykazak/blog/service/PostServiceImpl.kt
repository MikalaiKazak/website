package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.repository.PostRepository
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
	override fun findAllPosts(pageable: Pageable): List<Post> {
		return postRepository.findPosts(pageable)
	}

	@Transactional(readOnly = true)
	override fun findPostByPostId(postId: Long): Post {
		return postRepository.findById(postId)
			.orElseThrow { EntityNotFoundException("Post with id=$postId not found") }
	}

	@Transactional(readOnly = true)
	override fun findAllPostsByTag(tag: String, pageable: Pageable): List<Post> {
		return postRepository.findAllByTags_Tag(tag, pageable)
	}
}