package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostResponse
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "post", description = "Api for operate with posts")
interface PostController {

    @Operation(summary = "Publish post")
    fun publishPost(request: PostCreateRequest): PostResponse

    @Operation(summary = "Find all posts")
    fun findPosts(
        @Parameter(description = "zero-based page index") page: Int,
        @Parameter(description = " the size of the page to be returned") size: Int
    ): List<PostResponse>

    @Operation(summary = "Find all posts by tag")
    fun findPostsByTag(
        @Parameter(description = "tag") tag: String,
        @Parameter(description = "zero-based page index") page: Int,
        @Parameter(description = " the size of the page to be returned") size: Int
    ): List<PostResponse>

    @Operation(summary = "Find post by id")
    fun findPostById(
        @Parameter(description = "post id") id: Long
    ): PostResponse

    @Operation(summary = "Delete post by id")
    fun deletePostById(
        @Parameter(description = "post id") id: Long
    )

    @Operation(summary = "Update post")
    fun updatePost(request: PostUpdateRequest): PostResponse
}