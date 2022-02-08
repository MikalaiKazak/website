package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.dto.tag.TagRequest
import com.mikalaykazak.blog.dto.tag.TagResponse
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
	override fun createTag(tagRequest: TagRequest) = when {
		existsByTag(tagRequest.tag) -> throw EntityNotFoundException("Tag ${tagRequest.tag} already exists")
		else -> tagRepository.save(tagRequest.toEntity()).toResponse()
	}

	@Transactional(readOnly = true)
	override fun existsByTag(tag: String) = tagRepository.existsById(tag)

	@Transactional
	override fun deleteByTag(tag: String) = tagRepository.deleteById(tag)

	@Transactional(readOnly = true)
	override fun findAll(): List<TagResponse> = tagRepository.findAll().toResponses()

	@Transactional(readOnly = true)
	override fun findAllByTag(tags: Array<String>) =
		tagRepository.findAllByTagIn(tags).map(Tag::toResponse)

	@Transactional(readOnly = true)
	override fun findEntityByTag(tag: String): Tag {
		return tagRepository.findById(tag)
			.orElseThrow { EntityNotFoundException("Tag $tag not found") }
	}

	@Transactional(readOnly = true)
	override fun findByTag(tag: String) = findEntityByTag(tag).toResponse()
}