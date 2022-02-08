package com.mikalaykazak.blog.entity

enum class Vote(val vote: Int) {
	LIKE(1),
	DISLIKE(-1),
	NONE(0);

	companion object {
		private val VALUES = values()
		fun fromInt(value: Int) = VALUES.first { it.vote == value }
	}
}