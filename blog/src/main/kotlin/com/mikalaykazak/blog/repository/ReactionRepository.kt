package com.mikalaykazak.blog.repository

import com.mikalaykazak.blog.entity.Reaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactionRepository : JpaRepository<Reaction, Reaction.ReactionId>