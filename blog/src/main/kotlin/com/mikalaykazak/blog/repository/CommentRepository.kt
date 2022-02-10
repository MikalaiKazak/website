package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.Comment
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {

	@EntityGraph(value = "comment-post-entity-graph")
	fun findAllByPostId(postId: Long): Set<Comment>
}