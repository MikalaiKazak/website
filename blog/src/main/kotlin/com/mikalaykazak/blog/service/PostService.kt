package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Post

interface PostService {
	fun createPost(post: Post): Post
	fun findAll(): List<Post>
	fun findById(postId: Long): Post
	fun updatePost(post: Post): Post
	fun deleteById(postId: Long)
	fun existsById(postId: Long): Boolean
}