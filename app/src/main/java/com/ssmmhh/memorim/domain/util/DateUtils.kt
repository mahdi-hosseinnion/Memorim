package com.ssmmhh.memorim.domain.util

/**
 * a set of utils for date in app
 * we use this class for consistence coding
 */
object DateUtils {

    //TODO unit test this function
    fun currentTimeInSecond(): Long = (System.currentTimeMillis()).div(1_000)

}