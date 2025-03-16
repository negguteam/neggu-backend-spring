package com.neggu.neggu.controller.v1.insight

import com.neggu.neggu.dto.insight.InsightResponse
import com.neggu.neggu.model.user.User
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "05. [인사이트]")
interface InsightAPI {

    fun getInsight(
        @Schema(hidden = true) user: User,
    ): InsightResponse
}

