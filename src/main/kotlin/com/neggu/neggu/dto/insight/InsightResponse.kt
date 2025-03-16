package com.neggu.neggu.dto.insight

import com.neggu.neggu.model.cloth.Cloth
import com.neggu.neggu.model.cloth.Mood
import com.neggu.neggu.model.lookbook.LookBook

data class InsightResponse(
    val nickname: String,
    val mood: Mood? = null,
    val clothes:List<Cloth> = emptyList(),
    val clothCount : Int = 0,
    val lookBooks: List<LookBook> = emptyList(),
    val lookBookCount : Int = 0,
)