package com.ssmmhh.memorim.repositories

import com.ssmmhh.memorim.domain.models.Memo
import kotlinx.coroutines.flow.Flow

interface MemoRepository {

    fun observeMemos(): Flow<List<Memo>>

    suspend fun insertMemo(memo: Memo): Long

    suspend fun deleteMemo(memo: Memo): Int
}