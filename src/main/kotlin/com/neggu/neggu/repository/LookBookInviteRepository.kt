package com.neggu.neggu.repository

import com.neggu.neggu.model.invite.LookBookInvite
import org.springframework.data.mongodb.repository.MongoRepository

interface LookBookInviteRepository:MongoRepository<LookBookInvite, String> {

    fun deleteRefreshTokensByExpiredAtBefore(expiration: Long)
}