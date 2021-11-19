package com.ssmmhh.memorim.domain.util

import com.ssmmhh.memorim.domain.models.Memo
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

/**
 * a factory class to produce consistence instance of Memo while developing / testing
 */
object MemoFactory {


    /**
     * create a memo with given parameters
     */
    fun createMemo(
        id: Int = 0,
        title: String,
        description: String? = null,
        createdAt: Long = DateUtils.currentTimeInSecond(),
        updatedAt: Long = createdAt
    ): Memo = Memo(
        id = id,
        title = title,
        description = description,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )


    /**
     * create a random instance of memo class for testing
     */
    fun createRandomMemo(id: Int = 0): Memo {
        val currentTime = DateUtils.currentTimeInSecond()
        //createdAt value will be a random number between 'currentTime-range' till 'currentTime+range'
        val range = 10_000
        val createdAt = Random.nextLong(
            from = currentTime.minus(range),
            until = currentTime.plus(range)
        )
        // updatedAt value will be 'createdAt + random number(0 till range)'
        val updatedAt = createdAt.plus(Random.nextInt(range))
        return createMemo(
            id = id,
            //a random string with random length (between 2 until 20)
            title = UUID.randomUUID().toString().substring(0, Random.nextInt(2, 20)),
            //random empty or full description
            description = if (Random.nextBoolean()) null else UUID.randomUUID().toString(),
            createdAt =createdAt,
            updatedAt = updatedAt
        )
    }

    /**
     * create a random list of memos for testing
     */
    fun createListOfRandomMemos(size: Int): List<Memo> {
        val result = ArrayList<Memo>()
        repeat(size) {
            result.add(createRandomMemo())
        }
        return result
    }
}