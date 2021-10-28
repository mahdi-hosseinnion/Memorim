package com.ssmmhh.memorim.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ssmmhh.memorim.persistence.entities.MemoLocalEntity
import com.ssmmhh.memorim.utils.Logger.DEBUG

/**
 * The room database for app.
 */
@Database(entities = [MemoLocalEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memosDao(): MemosDao
}