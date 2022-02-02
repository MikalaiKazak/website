package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.PostCreateRequest
import com.mikalaykazak.blog.dto.PostResponse

interface PostService {

	fun createPost(postCreateRequest: PostCreateRequest): PostResponse

	fun findAll(): List<PostResponse>
}