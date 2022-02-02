package com.mikalaykazak.blog.entity

class Tag(
	val id: Long?,
	val tag: String,
) {

	constructor(tag: String) : this(null, tag)
}