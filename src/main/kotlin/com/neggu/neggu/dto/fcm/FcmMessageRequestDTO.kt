package com.neggu.neggu.dto.fcm

data class FcmMessageRequestDTO(
    val token: String? = null,
    val title: String,
    val body: String,
) {

    companion object{

        fun from(token: String?, title: String, body: String): FcmMessageRequestDTO {
            return FcmMessageRequestDTO(token, title, body)
        }
    }
}
