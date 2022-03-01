package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.dto.tag.TagResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "tag", description = "Api for operate with tags")
interface TagController {

    @Operation(summary = "create tag")
    fun createTag(request: TagRequest): TagResponse

    @Operation(summary = "delete tag")
    fun deleteTag(@Parameter(description = "tag") tag: String)
}