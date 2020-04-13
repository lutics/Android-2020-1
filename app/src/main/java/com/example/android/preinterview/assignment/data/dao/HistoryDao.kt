package com.example.android.preinterview.assignment.data.dao

import androidx.room.*
import com.example.android.preinterview.assignment.data.vo.ApiVO

@Dao
interface HistoryDao {

    @Query("SELECT * FROM History")
    suspend fun findAll(): List<ApiVO.History>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(history: ApiVO.History)

    @Delete
    suspend fun delete(history: ApiVO.History)
}