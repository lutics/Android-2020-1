package com.example.android.preinterview.assignment.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.preinterview.assignment.BuildConfig
import com.example.android.preinterview.assignment.data.dao.BookmarkDao
import com.example.android.preinterview.assignment.data.dao.HistoryDao
import com.example.android.preinterview.assignment.data.vo.ApiVO

@Database(
    entities = [
        ApiVO.Bookmark::class,
        ApiVO.History::class
    ],
    version = BuildConfig.DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun historyDao(): HistoryDao
}