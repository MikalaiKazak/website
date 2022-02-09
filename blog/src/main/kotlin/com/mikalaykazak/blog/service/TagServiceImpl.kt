package com.mikalaykazak.blog.service

import com.mikalaykazak.blog.entity.Tag
import com.mikalaykazak.blog.repository.TagRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class TagServiceImpl(private val tagRepository: TagRepository) : TagService {

	@Transactional
	override fun createTag(tag: Tag) = when {
		isTagExists(tag.tag) -> throw EntityNotFoundException("Tag ${tag.tag} already exists")
		else -> tagRepository.save(tag)
	}

	@Transactional(readOnly = true)
	override fun isTagExists(tag: String) = tagRepository.existsByTag(tag)

	@Transactional
	override fun deleteTag(tag: String) = tagRepository.deleteById(tag)
}