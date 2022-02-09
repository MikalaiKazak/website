package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.dto.tag.TagResponse
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.service.TagService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/tags")
class TagController(private val tagService: TagService) {

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createTag(@RequestBody @Valid tagRequest: TagRequest): TagResponse {
		val tag = tagRequest.toEntity()
		val createdTag = tagService.createTag(tag)
		return createdTag.toResponse()
	}

	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun deleteTag(@PathParam("tag") tag: String) = tagService.deleteTag(tag)
}