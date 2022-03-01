package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.post.PostCreateRequest
import com.mikalaykazak.blog.dto.post.PostResponse
import com.mikalaykazak.blog.dto.post.PostUpdateRequest
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.maper.toResponses
import com.mikalaykazak.blog.service.PostService
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostControllerImpl(
    private val postService: PostService
) : PostController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    override fun publishPost(@RequestBody @Valid request: PostCreateRequest): PostResponse {
        val post = request.toEntity()
        val createdPost = postService.createPost(post)
        return createdPost.toResponse()
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    override fun findPosts(
        @RequestParam("page", required = false, defaultValue = DEFAULT_PAGE) page: Int,
        @RequestParam("size", required = false, defaultValue = DEFAULT_PAGE_SIZE) size: Int,
    ): List<PostResponse> {
        val pageRequest = PageRequest.of(page, size)
        return postService.findAllPosts(pageRequest).toResponses()
    }

    @GetMapping("/", params = ["tag"])
    @ResponseStatus(HttpStatus.OK)
    override fun findPostsByTag(
        @RequestParam("tag") tag: String,
        @RequestParam("page", required = false, defaultValue = DEFAULT_PAGE) page: Int,
        @RequestParam("size", required = false, defaultValue = DEFAULT_PAGE_SIZE) size: Int,
    ): List<PostResponse> {
        val pageRequest = PageRequest.of(page, size)
        return postService.findAllPostsByTag(tag, pageRequest).toResponses()
    }

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    override fun findPostById(@PathVariable("postId") id: Long): PostResponse {
        val post = postService.findPostByPostId(id)
        return post.toResponse()
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    override fun deletePostById(@PathVariable("postId") id: Long) {
        postService.deletePostByPostId(id)
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    override fun updatePost(@RequestBody @Valid request: PostUpdateRequest): PostResponse {
        val post = request.toEntity()
        val updatedPost = postService.updatePost(post)
        return updatedPost.toResponse()
    }
}