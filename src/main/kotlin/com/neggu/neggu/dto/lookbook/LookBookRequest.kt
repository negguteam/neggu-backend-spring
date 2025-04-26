package com.neggu.neggu.dto.lookbook

import com.neggu.neggu.model.lookbook.LookBookCloth
import java.time.LocalDateTime

data class LookBookRequest(
    val lookBookClothes: List<LookBookCloth>,
    val targetDate: LocalDateTime? = null
)

data class LookBookByInviteRequest(
    val lookBookClothes: List<LookBookCloth>,
    val targetDate: LocalDateTime,
    val inviteCode: String,
)
