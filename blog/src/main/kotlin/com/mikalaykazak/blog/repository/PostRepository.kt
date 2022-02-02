package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.Post
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : PagingAndSortingRepository<Post, Long>