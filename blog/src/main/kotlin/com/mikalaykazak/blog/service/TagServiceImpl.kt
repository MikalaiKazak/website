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

	@Transactional()
	override fun createTag(tagRequest: TagRequest): TagResponse =
		tagRepository.save(tagRequest.toEntity()).toResponse()

	@Transactional()
	override fun deleteById(id: String) =
		tagRepository.deleteById(id)

	@Transactional(readOnly = true)
	override fun findAll(): List<TagResponse> =
		tagRepository.findAll().toResponses()


	@Transactional(readOnly = true)
	override fun findById(id: String): TagResponse = tagRepository.findById(id)
		.map(Tag::toResponse)
		.orElseThrow { EntityNotFoundException("Tag $id not found") }
}