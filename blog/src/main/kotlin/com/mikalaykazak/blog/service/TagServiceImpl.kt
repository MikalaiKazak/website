package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.TagRequest
import com.mikalaykazak.blog.dto.TagResponse
import com.mikalaykazak.blog.entity.Tag
import com.mikalaykazak.blog.maper.toEntity
import com.mikalaykazak.blog.maper.toResponse
import com.mikalaykazak.blog.maper.toResponses
import com.mikalaykazak.blog.repository.TagRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class TagServiceImpl(private val tagRepository: TagRepository) : TagService {

	@Transactional
	override fun createTag(tagRequest: TagRequest): TagResponse = when {
		tagRepository.existsById(tagRequest.tag) -> {
			throw EntityNotFoundException("Tag ${tagRequest.tag} already exists")
		} else -> {
			tagRepository.save(tagRequest.toEntity()).toResponse()
		}
	}

	@Transactional
	override fun deleteByTag(tag: String) = tagRepository.deleteById(tag)

	@Transactional(readOnly = true)
	override fun findAll(): List<TagResponse> = tagRepository.findAll().toResponses()

	@Transactional(readOnly = true)
	override fun findAllByTag(tags: Array<String>): List<TagResponse> = tagRepository.findAllByIdIn(tags).map(Tag::toResponse)

	@Transactional(readOnly = true)
	override fun findByTag(tag: String): TagResponse = tagRepository.findById(tag)
		.map(Tag::toResponse)
		.orElseThrow { EntityNotFoundException("Tag $tag not found") }
}