package com.mikalaykazak.blog.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "comment")
@NamedEntityGraph(
    name = "comment-post-entity-graph",
    attributeNodes = [
        NamedAttributeNode("post"),
        NamedAttributeNode("children")
    ]
)
class Comment(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,

	@Column(name = "user_id")
	val userId: Long,

	//TODO store in markdown or html
	@Column(name = "text")
	val text: String,

	@Column(name = "updated_at", nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id", nullable = false, updatable = false)
	val post: Post,

	@ManyToOne
	@JoinColumn(name = "parent_id")
	val parent: Comment? = null,

	@OneToMany(mappedBy = "parent")
	val children: Set<Comment> = setOf()
)