package com.mikalaykazak.blog.web

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.service.TagService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/tag")
class TagController(private val tagService: TagService) {

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	fun createTag(@RequestBody @Valid tagRequest: TagRequest) = tagService.createTag(tagRequest)

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun findAll() = tagService.findAll()

	@GetMapping("/", params = ["tags"])
	@ResponseStatus(HttpStatus.OK)
	fun findByTags(@PathParam("tags") tags: Array<String>) = tagService.findAllByTag(tags)

	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.OK)
	fun deleteById(@PathParam("tag") tag: String) = tagService.deleteByTag(tag)
}