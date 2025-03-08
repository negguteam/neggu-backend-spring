package com.neggu.neggu.service.invite

import com.neggu.neggu.model.invite.LookBookInvite
import com.neggu.neggu.model.user.User
import com.neggu.neggu.repository.LookBookInviteRepository
import org.springframework.stereotype.Service

@Service
class InviteService(
    private val lookBookInviteRepository: LookBookInviteRepository,
    private val codeGenerator: CodeGenerator
) {

    fun generateInviteCode(): String {
        var inviteCode: String
        do {
            inviteCode = codeGenerator.generateCode()
        } while (lookBookInviteRepository.existsById(inviteCode))
        return inviteCode
    }

    fun invite(user: User): LookBookInvite {
        val hourMilliseconds = 24 * 60 * 60 * 1000
        val lookBookInvite = LookBookInvite(
            id = generateInviteCode(),
            accountId = user.id!!,
            expiredAt = System.currentTimeMillis() + hourMilliseconds
        )
        return lookBookInviteRepository.save(lookBookInvite)
    }

}