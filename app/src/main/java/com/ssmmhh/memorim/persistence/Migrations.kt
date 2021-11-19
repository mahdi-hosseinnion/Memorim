package com.ssmmhh.memorim.persistence

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE memos ADD COLUMN createdAt INTEGER NOT NULL DEFAULT(0)")
            database.execSQL("ALTER TABLE memos ADD COLUMN updatedAt INTEGER NOT NULL DEFAULT(0)")
            database.execSQL("UPDATE memos SET createdAt = id")
            database.execSQL("UPDATE memos SET updatedAt = createdAt")
        }
    }
}