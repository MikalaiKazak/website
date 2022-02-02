package com.mikalaykazak.blog.entity

import org.hibernate.annotations.SQLDelete
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Entity
@Table(name = "post")
@SQLDelete(sql = "UPDATE post SET state=\'REMOVED\' WHERE id=?")
class Post(
	id: Long = 0,

	@Column(name = "title", nullable = false) val title: String,

	@Column(name = "text", nullable = false) val text: String,

	@Column(
		name = "state",
		nullable = false
	) @Enumerated(value = EnumType.STRING) val state: State,

	@Column(name = "author_id", nullable = false) val authorId: Long,
) : BaseEntity(id)