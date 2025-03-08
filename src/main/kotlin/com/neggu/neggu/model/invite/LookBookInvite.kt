package com.neggu.neggu.model.invite

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document("lookbook_invite")
data class LookBookInvite(
    val id: String,
    val accountId: ObjectId,
    val expiredAt: Long,
    val createdAt: Long = System.currentTimeMillis()
)