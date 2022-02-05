package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import com.mikalaykazak.blog.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post")
class PostController(private val postService: PostService) {

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createPost(@RequestBody @Valid postCreateRequest: PostCreateRequest) = postService.createPost(postCreateRequest)

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun findAll() = postService.findAll()

	@GetMapping("/{postId}")
	@ResponseStatus(HttpStatus.OK)
	fun findById(@PathVariable("postId") postId: Long) = postService.findById(postId)

	@DeleteMapping("/{postId}")
	@ResponseStatus(HttpStatus.OK)
	fun deleteById(@PathVariable("postId") postId: Long) = postService.deleteById(postId)

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun updatePost(@RequestBody @Valid postUpdateRequest: PostUpdateRequest) = postService.updatePost(postUpdateRequest)
}