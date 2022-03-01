package com.mikalaykazak.blog.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "reaction")
class Reaction(

    @EmbeddedId
    @Column(name = "id", nullable = false, unique = true)
    val id: ReactionId,

    @Column(name = "is_liked", nullable = false)
    val isLiked: Boolean,

    @MapsId("post_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id", nullable = false)
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