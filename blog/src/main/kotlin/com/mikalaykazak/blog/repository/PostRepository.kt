package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PostRepository : JpaRepository<Post, Long> {
	fun findAllByStateIsNot(state: State): List<Post>
}