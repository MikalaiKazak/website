package com.mikalaykazak.blog.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.NamedAttributeNode
import javax.persistence.NamedEntityGraph
import javax.persistence.Table

@Entity
@Table(name = "post")
@NamedEntityGraph(name = "post-tag-entity-graph",
	attributeNodes = [NamedAttributeNode("tags")]
)
@DynamicUpdate
class Post(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	val id: Long? = null,

	@Column(name = "headline", nullable = false)
	val headline: String,

	// TODO I still don't know why i need Markdown with HTML insted of only store html in db
	// TODO Need do some researches
	@Column(name = "markdown_body", nullable = false)
	val markdownBody: String,

	@Column(
		name = "state",
		nullable = false
	)
	@Enumerated(value = EnumType.STRING)
	val state: State,

	@Column(name = "author_id", nullable = false)
	val authorId: Long,

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "post_tag",
		joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
		inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
	)
	val tags: List<Tag>,

	// TODO maybe this redundant
//	@OneToMany(cascade = [CascadeType.ALL], mappedBy = "post", fetch = FetchType.EAGER)
//	val comments: List<Comment> = listOf(),

	@Column(name = "html_body", nullable = false)
	var htmlBody: String = "",
) : BaseEntity()