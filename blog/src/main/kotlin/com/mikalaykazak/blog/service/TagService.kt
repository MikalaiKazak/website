package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.TagRequest
import com.mikalaykazak.blog.dto.TagResponse

interface TagService {

	fun createTag(tagRequest: TagRequest): TagResponse

	fun deleteByTag(tag: String)

	fun findAll(): List<TagResponse>

	fun findAllByTag(tags: Array<String>): List<TagResponse>

	fun findByTag(tag: String): TagResponse
}