package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.PublishDelayPostEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

//TODO change name
@Repository
interface PostPublishTaskRepository : JpaRepository<PublishDelayPostEvent, Long> {

	fun findAllByPublishAtIsLessThanEqual(date: LocalDateTime): List<PublishDelayPostEvent>
}