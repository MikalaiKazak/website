package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.ResponseWithPage
import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostResponse
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.maper.toResponses
import com.mikalaykazak.blog.service.PostService
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createPost(@RequestBody @Valid postCreateRequest: PostCreateRequest): PostResponse {
		val post = postCreateRequest.toEntity()
		val createdPost = postService.createPost(post)
		return createdPost.toResponse()
	}

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun findAllPosts(
		@RequestParam("page", required = false, defaultValue = DEFAULT_PAGE) page: Int,
		@RequestParam("size", required = false, defaultValue = DEFAULT_PAGE_SIZE) size: Int,
	): ResponseWithPage<List<PostResponse>> {
		val postSlice = postService.findAllPosts(PageRequest.of(page, size))

		return ResponseWithPage(
			data = postSlice.content.toResponses(),
			currentPage = postSlice.number,
			totalPages = postSlice.totalPages,
			totalElements = postSlice.totalElements
		)
	}

	@GetMapping("/", params = ["tag"])
	@ResponseStatus(HttpStatus.OK)
	fun findAllPostsByTag(
		@RequestParam("tag") tag: String,
		@RequestParam("page", required = false, defaultValue = DEFAULT_PAGE) page: Int,
		@RequestParam("size", required = false, defaultValue = DEFAULT_PAGE_SIZE) size: Int,
	): ResponseWithPage<List<PostResponse>> {
		val postSlice = postService.findAllPostsByTag(tag, PageRequest.of(page, size))

		return ResponseWithPage(
			data = postSlice.content.toResponses(),
			currentPage = postSlice.number,
			totalPages = postSlice.totalPages,
			totalElements = postSlice.totalElements
		)
	}

	@GetMapping("/{postId}")
	@ResponseStatus(HttpStatus.OK)
	fun findPostByPostId(@PathVariable("postId") postId: Long): PostResponse {
		val post = postService.findPostByPostId(postId)
		return post.toResponse()
	}

	@DeleteMapping("/{postId}")
	@ResponseStatus(HttpStatus.OK)
	fun deletePostByPostId(@PathVariable("postId") postId: Long) {
		postService.deletePostByPostId(postId)
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun updatePost(@RequestBody @Valid postUpdateRequest: PostUpdateRequest): PostResponse {
		val post = postUpdateRequest.toEntity()
		val updatedPost = postService.updatePost(post)
		return updatedPost.toResponse()
	}
}