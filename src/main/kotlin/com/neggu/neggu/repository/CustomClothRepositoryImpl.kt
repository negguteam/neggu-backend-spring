package com.neggu.neggu.repository

import com.neggu.neggu.model.cloth.Category
import com.neggu.neggu.model.cloth.Cloth
import com.neggu.neggu.model.cloth.ClothColor
import com.neggu.neggu.model.cloth.Mood
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.support.PageableExecutionUtils

class CustomClothRepositoryImpl(
    private val mongoTemplate: MongoTemplate
) : CustomClothRepository {

    override fun findClothesDynamic(
        acountId: ObjectId,
        category: Category?,
        colors: List<ClothColor>?,
        moods: Mood?,
        pageable: Pageable,
    ): Page<Cloth> {
        val query = Query().apply {
            addCriteria(Criteria.where("accountId").`is`(acountId))
            category?.let { addCriteria(Criteria.where("category").`is`(it)) }
            colors?.takeIf { it.isNotEmpty() }?.let {
                addCriteria(Criteria.where("clothColor").`in`(it))
            }
            moods?.let {
                addCriteria(Criteria.where("mood").`in`(it))
            }
            with(pageable)
        }

        val items = mongoTemplate.find(query, Cloth::class.java)
        return PageableExecutionUtils.getPage(
            items, pageable
        ) { mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Cloth::class.java) }
    }

}

