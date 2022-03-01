package com.mikalaykazak.blog.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "post")
@NamedEntityGraph(
    name = "post-tag-entity-graph",
    attributeNodes = [
        NamedAttributeNode("tags")
    ]
)
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	val id: Long? = null,

    @Column(name = "headline", nullable = false)
    val headline: String,

    @Column(name = "state", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val state: State,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @ManyToMany
    @JoinTable(
        name = "post_tag",
        joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "tag")]
    )
    val tags: List<Tag>,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "html_body", nullable = false)
    val htmlBody: String,
)