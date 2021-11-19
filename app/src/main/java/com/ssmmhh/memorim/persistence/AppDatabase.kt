package com.ssmmhh.memorim.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ssmmhh.memorim.persistence.entities.MemoLocalEntity

/**
 * The room database for app.
 */
@Database(entities = [MemoLocalEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memosDao(): MemosDao

    companion object {
        const val DATABASE_NAME = "memos.db"
    }
}