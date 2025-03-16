package com.neggu.neggu.dto.fcm

data class FcmMessageRequest(
    val token: String? = null,
    val title: String,
    val body: String,
) {

    companion object{

        fun from(token: String?, title: String, body: String): FcmMessageRequest {
            return FcmMessageRequest(token, title, body)
        }
    }
}
