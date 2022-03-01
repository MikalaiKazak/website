package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Post
import org.springframework.data.domain.Pageable

interface PostService {
    fun createPost(post: Post): Post
    fun findPostByPostId(postId: Long): Post
    fun updatePost(post: Post): Post
    fun deletePostByPostId(postId: Long)
    fun isPostExistsByPostId(postId: Long): Boolean
    fun findAllPostsByTag(tag: String, pageable: Pageable): List<Post>
    fun findAllPosts(pageable: Pageable): List<Post>
}