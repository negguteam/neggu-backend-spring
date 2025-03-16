package com.neggu.neggu.cronjob

import com.neggu.neggu.config.LoggerConfig.log
import com.neggu.neggu.config.LoggerConfig.nInfo
import com.neggu.neggu.repository.LookBookInviteRepository
import com.neggu.neggu.repository.RefreshTokenRepository
import com.neggu.neggu.util.Constants.DEFAULT_DATETIME_FORMATTER
import com.neggu.neggu.util.Constants.DEFAULT_TIME_ZONE
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class InviteCodeCronJob(
    private val inviteRepository: LookBookInviteRepository
) {

    @Scheduled(cron = "0 0 0 */1 * *")
    fun cron() {
        val currentEpoch = System.currentTimeMillis()
        inviteRepository.deleteRefreshTokensByExpiredAtBefore(currentEpoch)
        log.nInfo("[Invite Code Cleared] ${Instant.ofEpochMilli(currentEpoch).atZone(DEFAULT_TIME_ZONE).format(DEFAULT_DATETIME_FORMATTER)} 이전의 RefreshToken 삭제 완료")
    }
}