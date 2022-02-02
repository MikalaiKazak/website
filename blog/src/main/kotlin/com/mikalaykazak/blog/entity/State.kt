package com.mikalaykazak.blog.entity

enum class State {
	// The post was published
	PUBLISHED,

	// The post is in unfinished or not ready for publication
	DRAFT,

	// The post is published, but hidden to readers
	HIDDEN,

	// THe post was removed
	REMOVED;
}