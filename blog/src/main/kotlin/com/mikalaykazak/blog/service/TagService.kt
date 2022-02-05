package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.dto.tag.TagResponse
import com.mikalaykazak.blog.entity.Tag

interface TagService {

	fun createTag(tagRequest: TagRequest): TagResponse

	fun deleteByTag(tag: String)

	fun findAll(): List<TagResponse>

	fun findAllByTag(tags: Array<String>): List<TagResponse>

	fun findByTag(tag: String): TagResponse

	fun findEntityByTag(tag: String): Tag
	fun existsByTag(tag: String): Boolean
}