package com.neggu.neggu.dto.user

import io.swagger.v3.oas.annotations.media.Schema

@Schema(
    name = "RefreshToken Response",
    description = "토큰 갱신 응답",
)
data class TokenResponse(
    @field:Schema(description = "AccessToken", example = "accessToken")
    val accessToken: String,
    @field:Schema(description = "accessToken 만료일자(초)", example = "604800(1주일)")
    val expiresIn: Long,
    @field:Schema(description = "RefreshToken", example = "refreshToken")
    val refreshToken: String,
    @field:Schema(description = "refreshToken 만료일자(초)", example = "15552000(6개월)")
    val refreshTokenExpiresIn: Long,
)