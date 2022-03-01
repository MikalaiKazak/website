package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.Post
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostRepository : JpaRepository<Post, Long> {

	@Query("UPDATE #{#entityName} p SET p.state=\'REMOVED\' WHERE p.id=?1")
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	fun softDelete(postId: Long)

	@Query("SELECT p FROM #{#entityName} p WHERE p.state<>\'REMOVED\'")
	@EntityGraph(value = "post-tag-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
	fun findPosts(pageable: Pageable): List<Post>

	@Query("SELECT p FROM #{#entityName} p WHERE p.id=?1 AND p.state<>\'REMOVED\'")
	@EntityGraph(value = "post-tag-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
	override fun findById(postId: Long): Optional<Post>

	@Query("SELECT COUNT(p) = 1 FROM #{#entityName} p WHERE p.id=?1 AND p.state<>\'REMOVED\'")
	override fun existsById(postId: Long): Boolean

	@EntityGraph(value = "post-tag-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
	fun findAllByTags_Tag(tag: String, pageable: Pageable): List<Post>
}