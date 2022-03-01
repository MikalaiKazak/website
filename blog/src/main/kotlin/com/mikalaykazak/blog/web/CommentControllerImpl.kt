package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.service.CommentService
import com.mikalaykazak.blog.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/posts/{postId}/comments")
class CommentControllerImpl(
    private val commentService: CommentService,
    private val postService: PostService
) : CommentController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    override fun addCommentToPost(
        @PathVariable("postId") postId: Long,
        @RequestBody @Valid request: CommentCreateRequest,
    ): CommentResponse {
        val post = postService.findPostByPostId(postId)
        val comment = request.toEntity(post)
        val savedComment = commentService.createCommentForPost(postId, comment)
        return savedComment.toResponse()
    }
}