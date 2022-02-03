package com.mikalaykazak.blog.entity

import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@EntityListeners(value = [AuditingEntityListener::class])
@DynamicUpdate
@DynamicInsert
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "post")
class Post(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,

	@Column(name = "headline", nullable = false)
	val headline: String,

	@Column(name = "markdown_body", nullable = false)
	val markdownBody: String,

	@Column(
		name = "state",
		nullable = false
	) @Enumerated(value = EnumType.STRING)
	val state: State,

	@Column(name = "author_id", nullable = false)
	val authorId: Long,

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "post_tag",
		joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
		inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
	)
	val tags: List<Tag>,

	@Column(name = "updated_at", nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
	@Column(name = "html_body", nullable = false)
	lateinit var htmlBody: String
}