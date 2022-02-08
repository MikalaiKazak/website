package com.mikalaykazak.blog.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Entity
@Table(name = "reaction")
class Reaction(

	@EmbeddedId
	@Column(name = "id", nullable = false)
	val id: ReactionId,

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "vote", nullable = false)
	val vote: Vote = Vote.NONE
) {

	@Embeddable
	class ReactionId(
		@Column(name = "user_id", nullable = false)
		val userId: Long,

		@Column(name = "post_id", nullable = false)
		val postId: Long,
	) : Serializable
}