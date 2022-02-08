package com.mikalaykazak.blog.entity

import org.hibernate.annotations.DynamicUpdate
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table

@Entity
@Table(name = "reaction")
@DynamicUpdate
class Reaction(

	@EmbeddedId
	@Column(name = "id", nullable = false)
	val id: ReactionId,

	@Column(name = "vote", nullable = false)
	val vote: Int,

	@MapsId("post_id")
	@ManyToOne(optional = false)
	@JoinColumn(name = "post_id", nullable = false, updatable = false)
	val post: Post,
) {

	@Embeddable
	class ReactionId(
		@Column(name = "user_id", nullable = false)
		val userId: Long,

		@Column(name = "post_id", nullable = false)
		val postId: Long,
	) : Serializable
}