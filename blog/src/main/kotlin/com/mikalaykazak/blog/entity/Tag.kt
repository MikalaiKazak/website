package com.mikalaykazak.blog.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tag")
class Tag(
    @Id
    @Column(name = "tag")
    val tag: String,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    val posts: List<Post> = listOf(),
)