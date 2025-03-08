package com.neggu.neggu.model.lookbook

import org.bson.types.ObjectId
import java.time.LocalDateTime

data class LookBookDecorator(
    val accountId: ObjectId,
    val imageUrl: String?,
    val targetDate: LocalDateTime,
)