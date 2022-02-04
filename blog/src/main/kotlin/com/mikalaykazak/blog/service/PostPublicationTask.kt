package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.PostResponse
import com.mikalaykazak.blog.entity.Post
import com.mikalaykazak.blog.entity.PublishDelayPostEvent
import com.mikalaykazak.blog.entity.State
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.repository.PostPublishTaskRepository
import com.mikalaykazak.blog.repository.PostRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

//TODO change name
@Service
class PostPublicationTask(
	private val postPublishTaskRepository: PostPublishTaskRepository,
	private val postRepository: PostRepository,
	private val notificationService: NotificationService
) {

	@Transactional
	@Scheduled(cron = "0 0/30 * * * ?")
	fun performTask() {
		val tasks = fetchActiveTasks()
		val posts = publishPosts(tasks)
		sendNotification(posts)
		deleteExecutedTasks(tasks)
	}

	private fun deleteExecutedTasks(tasks: List<PublishDelayPostEvent>) {
		postPublishTaskRepository.deleteAll(tasks)
	}

	private fun fetchActiveTasks() =
		postPublishTaskRepository.findAllByPublishAtIsLessThanEqual(LocalDateTime.now())

	private fun publishPosts(tasks: List<PublishDelayPostEvent>): List<PostResponse> =
		tasks.asSequence()
			.map(PublishDelayPostEvent::postId)
			.map(postRepository::findById)
			.filter(Optional<Post>::isPresent)
			.map(Optional<Post>::get)
			.map {
				Post(
					id = it.id,
					headline = it.headline,
					markdownBody = it.markdownBody,
					state = State.PUBLISHED,
					authorId = it.authorId,
					tags = it.tags,
					htmlBody = it.htmlBody
				)
			}
			.map(postRepository::save)
			.map(Post::toResponse)
			.toList()

	private fun sendNotification(posts: List<PostResponse>) {
		notificationService.sendNotification()
	}
}