package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.dto.PostUpdateRequest

interface PostService {
	fun createPost(postCreateRequest: PostCreateRequest): PostResponse
	fun findAll(): List<PostResponse>
	fun findById(postId: Long): PostResponse
	fun updatePost(postUpdateRequest: PostUpdateRequest): PostResponse
	fun deleteById(postId: Long)
}