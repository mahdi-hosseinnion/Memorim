package com.ssmmhh.memorim.persistence.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memos")
data class MemoLocalEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    //default value is 0 only for column to be same as migration1-2
    @ColumnInfo(name = "createdAt", defaultValue = "0") val createdAt: Long,
    @ColumnInfo(name = "updatedAt", defaultValue = "0") val updatedAt: Long,
)
