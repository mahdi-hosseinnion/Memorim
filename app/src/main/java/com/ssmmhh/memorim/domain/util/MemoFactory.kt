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
        description: String? = null
    ): Memo = Memo(
        id = id,
        title = title,
        description = description
    )


    /**
     * create a random instance of memo class for testing
     */
    fun createRandomMemo(id: Int = 0): Memo = Memo(
        id = id,
        //a random string with random length (between 2 until 20)
        title = UUID.randomUUID().toString().substring(0, Random.nextInt(2, 20)),
        //random empty or full description
        description = if (Random.nextBoolean()) null else UUID.randomUUID().toString()
    )

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