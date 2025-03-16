package com.neggu.neggu.dto.user

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank


@Schema(
    name = "Id Token Request",
    description = "Id Token 요청",
)
data class UserLoginRequest(
    @field:Schema(description = "idToken", example = "idToken")
    @field:NotBlank(message = "idToken은 필수값입니다.")
    val idToken: String,
    @field:Schema(description = "fcmToken", example = "fcmToken")
    val fcmToken: String? = null,
)