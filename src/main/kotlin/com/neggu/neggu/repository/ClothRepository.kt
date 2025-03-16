package com.neggu.neggu.repository

import com.neggu.neggu.model.cloth.*
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ClothRepository : MongoRepository<Cloth, ObjectId>, CustomClothRepository {

    fun findAllByAccountIdAndIsDeletedFalse(accountId: ObjectId): List<Cloth>
    fun findAllByAccountId(accountId: ObjectId): List<Cloth>
}