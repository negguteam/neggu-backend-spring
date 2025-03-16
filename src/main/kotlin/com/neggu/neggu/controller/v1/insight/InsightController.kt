package com.neggu.neggu.controller.v1.insight

import com.neggu.neggu.annotation.AccessTokenRequire
import com.neggu.neggu.config.LoginUser
import com.neggu.neggu.dto.insight.InsightResponse
import com.neggu.neggu.model.user.User
import com.neggu.neggu.service.insight.InsightService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/insight")
class InsightController(
    private val insightService: InsightService
) : InsightAPI {

    @AccessTokenRequire
    @GetMapping
    override fun getInsight(
        @LoginUser user: User
    ): InsightResponse {
        return insightService.getInsight(user)
    }
}