package com.ssmmhh.memorim.persistence

import androidx.room.*
import com.ssmmhh.memorim.persistence.entities.MemoLocalEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for the memos table.
 */
@Dao
interface MemosDao {


    /**
     * Observes list of memos.
     *
     * @return all memos.
     */
    @Query("SELECT * FROM memos")
    fun observeMemos(): Flow<List<MemoLocalEntity>>


    /**
     * Insert a single memo
     *
     * @return the 'rowId' of inserted memo
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(memoEntity: MemoLocalEntity): Long

    /**
     * Delete a single memo
     *
     * @return an int value indicating the number of rows that were deleted successfully
     */
    @Delete
    suspend fun deleteMemo(memoEntity: MemoLocalEntity)

}