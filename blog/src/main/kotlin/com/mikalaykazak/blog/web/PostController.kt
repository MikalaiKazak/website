package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
	fun createPost(@RequestBody @Valid postCreateRequest: PostCreateRequest): PostResponse {
		return postService.createPost(postCreateRequest)
	}

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun findAll(): List<PostResponse> {
		return postService.findAll()
	}
}