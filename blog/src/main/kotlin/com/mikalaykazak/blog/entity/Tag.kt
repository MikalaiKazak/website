package com.mikalaykazak.blog.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tag")
@DynamicUpdate
class Tag(
	@Id
	val id: String,

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	val posts: List<Post> = listOf(),
) : BaseEntity() {

}