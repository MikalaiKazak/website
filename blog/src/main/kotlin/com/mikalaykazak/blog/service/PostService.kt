package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostResponse
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import com.mikalaykazak.blog.entity.Post

interface PostService {
	fun createPost(postCreateRequest: PostCreateRequest): PostResponse
	fun findAll(): List<PostResponse>
	fun findById(postId: Long): PostResponse
	fun updatePost(postUpdateRequest: PostUpdateRequest): PostResponse
	fun deleteById(postId: Long)
	fun findEntityById(postId: Long): Post
	fun existsById(postId: Long): Boolean
}