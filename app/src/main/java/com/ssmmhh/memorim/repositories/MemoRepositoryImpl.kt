package com.ssmmhh.memorim.repositories

import com.ssmmhh.memorim.domain.models.Memo
import com.ssmmhh.memorim.persistence.MemosDao
import com.ssmmhh.memorim.persistence.utils.MemoLocalMapper.toDomainModelList
import com.ssmmhh.memorim.persistence.utils.MemoLocalMapper.toEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MemoRepositoryImpl
constructor(
    private val memosDao: MemosDao
) : MemoRepository {

    override fun observeMemos(): Flow<List<Memo>> =
        memosDao.observeMemos().map { it.toDomainModelList() }

    override suspend fun insertMemo(memo: Memo): Long =
        memosDao.insertMemo(memoEntity = memo.toEntityModel())

    override suspend fun deleteMemo(memo: Memo): Int =
        memosDao.deleteMemo(memoEntity = memo.toEntityModel())
}