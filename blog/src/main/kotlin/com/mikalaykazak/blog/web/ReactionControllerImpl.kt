package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.reaction.ReactionRequest
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.service.PostService
import com.mikalaykazak.blog.service.ReactionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/posts/{postId}/reaction")
class ReactionControllerImpl(
    private val reactionService: ReactionService,
    private val postService: PostService,
) : ReactionController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    override fun addReactionToPost(
        @PathVariable("postId") postId: Long,
        @RequestBody @Valid request: ReactionRequest,
    ) {
        val post = postService.findPostByPostId(postId)
        val reaction = request.toEntity(post)
        reactionService.addReaction(reaction)
    }
}