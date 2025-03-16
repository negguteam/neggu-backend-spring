package com.neggu.neggu.service.fcm

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import com.neggu.neggu.config.LoggerConfig.log
import com.neggu.neggu.config.LoggerConfig.nError
import com.neggu.neggu.dto.fcm.FcmMessageRequest
import org.springframework.stereotype.Service


@Service
class FcmService {

    fun sendMessage(fcmMessageRequest: FcmMessageRequest): String {
        val message = generateMessage(fcmMessageRequest)
        return fcmMessageRequest.token?.let {
            return try {
                val response = FirebaseMessaging.getInstance().send(message)
                "Message sent successfully : $response"
            } catch (e: Exception) {
                e.printStackTrace()
                log.nError(e.message.toString())
                "Failed to send message"
            }
        } ?: "Failed to send message"
    }

    private fun generateMessage(fcmMessageRequest: FcmMessageRequest): Message =
        Message.builder()
            .setToken(fcmMessageRequest.token)
            .setNotification(
                Notification.builder()
                    .setTitle(fcmMessageRequest.title)
                    .setBody(fcmMessageRequest.body)
                    .build()
            )
            .build()
}