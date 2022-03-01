package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.dto.tag.TagResponse
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.service.TagService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/tags")
class TagControllerImpl(
    private val tagService: TagService
) : TagController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    override fun createTag(@RequestBody @Valid request: TagRequest): TagResponse {
        val tag = request.toEntity()
        val createdTag = tagService.createTag(tag)
        return createdTag.toResponse()
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    override fun deleteTag(@PathParam("tag") tag: String) = tagService.deleteTag(tag)
}