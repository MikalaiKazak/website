package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.TagRequest
import com.mikalaykazak.blog.dto.TagResponse

interface TagService {

	fun create(tagRequest: TagRequest): TagResponse

	fun deleteById(id: String)

	fun findAll(): List<TagResponse>

	fun findById(id: String): TagResponse
}