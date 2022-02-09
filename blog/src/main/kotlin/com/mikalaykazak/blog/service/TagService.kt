package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Tag

interface TagService {

	fun createTag(tag: Tag): Tag

	fun deleteTag(tag: String)

	fun isTagExists(tag: String): Boolean
}