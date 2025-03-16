package com.neggu.neggu.service.lookbook

import com.neggu.neggu.config.LoggerConfig.log
import com.neggu.neggu.config.LoggerConfig.nInfo
import com.neggu.neggu.dto.lookbook.LookBookByInviteRequest
import com.neggu.neggu.dto.lookbook.LookBookRequest
import com.neggu.neggu.exception.ErrorType
import com.neggu.neggu.exception.ServerException
import com.neggu.neggu.exception.UnAuthorizedException
import com.neggu.neggu.model.lookbook.LookBook
import com.neggu.neggu.model.lookbook.LookBookDecorator
import com.neggu.neggu.model.user.User
import com.neggu.neggu.repository.LookBookInviteRepository
import com.neggu.neggu.repository.LookBookRepository
import com.neggu.neggu.repository.UserRepository
import com.neggu.neggu.service.aws.S3Service
import com.neggu.neggu.util.toObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class LookBookService(
    private val lookBookRepository: LookBookRepository,
    private val userRepository: UserRepository,
    private val s3Service: S3Service,
    private val inviteRepository: LookBookInviteRepository
) {

    @Transactional
    fun registerLookBook(user: User, image: MultipartFile, lookBookRequest: LookBookRequest): LookBook {
        val fileName = s3Service.uploadFile(user, image)
        val savedLookBook = lookBookRepository.save(LookBook(
            accountId = user.id!!,
            imageUrl = fileName,
            lookBookClothes = lookBookRequest.lookBookClothes
        ))
        userRepository.save(user.copy(lookBooks = user.lookBooks + savedLookBook.id!!))
        return savedLookBook.also {
            log.nInfo("[Register] LookBook(${it.id}) by user ${user.id}\n Info : $it")
        }
    }

    @Transactional
    fun registerLookBook(user: User, image: MultipartFile, lookBookRequest: LookBookByInviteRequest): LookBook {
        val lookBookInvite = inviteRepository.findByIdOrNull(lookBookRequest.inviteCode) ?: throw ServerException(ErrorType.NotFoundInvite)
        val invitedUser = userRepository.findByIdOrNull(lookBookInvite.accountId) ?: throw ServerException(ErrorType.NotFoundUser)
        val fileName = s3Service.uploadFile(user, image)
        val savedLookBook = lookBookRepository.save(LookBook(
            accountId = invitedUser.id!!,
            imageUrl = fileName,
            lookBookClothes = lookBookRequest.lookBookClothes,
            decorator = LookBookDecorator(
                accountId = user.id!!,
                imageUrl = user.profileImage,
                targetDate = lookBookRequest.targetDate,
            )
        ))
        userRepository.save(invitedUser.copy(lookBooks = invitedUser.lookBooks + savedLookBook.id!!))
        return savedLookBook.also {
            log.nInfo("[Register] LookBook(${it.id}) by user ${user.id}\n Info : $it")
        }
    }

    @Transactional
    fun deleteLookBook(user: User, lookBookId: String): LookBook {
        val lookBook = lookBookRepository.findByIdOrNull(lookBookId.toObjectId()) ?: throw ServerException(ErrorType.NotFoundLookBook)
        if (lookBook.accountId != user.id) { throw UnAuthorizedException(ErrorType.InvalidIdToken) }
        s3Service.deleteFile(lookBook.imageUrl)
        lookBookRepository.save(lookBook.copy(isDeleted = true))
        userRepository.save(user.copy(lookBooks = user.lookBooks.filter { it != lookBook.id }))
        return lookBook.also {
            log.nInfo("[Delete] LookBook(${it.id}) by user ${user.id}\n Info : $it")
        }
    }

    fun getLookBooks(user: User, size: Int, page: Int): Page<LookBook> {
        return lookBookRepository.findAllByAccountIdAndIsDeletedFalse(user.id!!, PageRequest.of(page, size, Sort.by("createdAt").descending()))
    }

    fun getLookBook(user: User, lookBookId: String): LookBook {
        return lookBookRepository.findByIdOrNull(lookBookId.toObjectId()) ?: throw ServerException(ErrorType.NotFoundLookBook)
    }

}