package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.comment.CommentCreateRequest
import com.mikalaykazak.blog.dto.comment.CommentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "comment", description = "Api for operate with comments")
interface CommentController {

    @Operation(summary = "add comment to post")
    fun addCommentToPost(
        @Parameter(description = "post id") postId: Long,
        request: CommentCreateRequest,
    ): CommentResponse
}