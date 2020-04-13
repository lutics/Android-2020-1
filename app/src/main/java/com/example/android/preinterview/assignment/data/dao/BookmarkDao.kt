package com.example.android.preinterview.assignment.data.dao

import androidx.room.*
import com.example.android.preinterview.assignment.data.vo.ApiVO

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM Bookmark")
    suspend fun findAll(): List<ApiVO.Bookmark>

    @Query("SELECT * FROM Bookmark WHERE isbn13 = :isbn13")
    suspend fun findById(isbn13: String): ApiVO.Bookmark?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(bookmark: ApiVO.Bookmark)

    @Delete
    suspend fun delete(bookmark: ApiVO.Bookmark)
}