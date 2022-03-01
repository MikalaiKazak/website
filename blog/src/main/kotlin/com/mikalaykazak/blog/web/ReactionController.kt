package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.reaction.ReactionRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "reaction", description = "Api for operate with reactions")
interface ReactionController {

    @Operation(summary = "add reaction to post by post id")
    fun addReactionToPost(
        @Parameter(description = "post id") postId: Long,
        request: ReactionRequest
    )
}