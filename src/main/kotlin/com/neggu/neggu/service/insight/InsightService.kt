package com.neggu.neggu.service.insight

import com.neggu.neggu.dto.insight.InsightResponse
import com.neggu.neggu.model.cloth.Cloth
import com.neggu.neggu.model.cloth.Mood
import com.neggu.neggu.model.user.User
import com.neggu.neggu.repository.ClothRepository
import com.neggu.neggu.repository.LookBookRepository
import org.springframework.stereotype.Service

@Service
class InsightService(
    private val clothRepository: ClothRepository,
    private val lookBookRepository: LookBookRepository,
) {

    fun getInsight(user: User): InsightResponse {
        // TODO fix Deleted
        val allClothes = clothRepository.findAllByAccountId(user.id!!)
        val allLookBooks = lookBookRepository.findAllByAccountIdAndIsDeletedFalse(user.id!!)

        println("All Clothes : $allClothes")
        val sortedMoods = getSortedMoodList(allClothes)
        if(sortedMoods.isEmpty()) return InsightResponse(nickname = user.nickname)

        val topMood = sortedMoods.first().mood
        val filteredClothes = allClothes.filter { it.mood.contains(topMood) }
        val filteredClotheIds = filteredClothes.mapNotNull { it.id }
        val filteredLookBooks = allLookBooks.filter { lookBook ->
            lookBook.lookBookClothes.any { filteredClotheIds.contains(it.id) }
        }

        return InsightResponse(
            nickname = user.nickname,
            mood = topMood,
            clothCount = filteredClotheIds.count(),
            clothes = filteredClothes,
            lookBookCount = filteredLookBooks.count(),
            lookBooks = filteredLookBooks
        )
    }

    private fun getSortedMoodList(allClothes: List<Cloth>): List<MoodCount> {
        val moodMap = mutableMapOf<Mood, Int>()
        allClothes.forEach { cloth ->
            cloth.mood.forEach { mood ->
                moodMap[mood] = moodMap.getOrDefault(mood, 0) + 1
            }
        }
        moodMap.toSortedMap(compareBy { it.kr }).toSortedMap(compareBy { moodMap[it] })
        val moodList = moodMap.toList()
            .sortedBy { (mood, _) -> mood.kr }
            .sortedByDescending { (_, value) -> value }
            .map { (mood, count) ->
                MoodCount(mood, count)
            }
        return moodList
    }

    data class MoodCount(
        val mood: Mood,
        val count: Int,
    )
}