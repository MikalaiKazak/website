package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : JpaRepository<Tag, String> {

	fun findAllByIdIn(tags: Array<String>): List<Tag>
}