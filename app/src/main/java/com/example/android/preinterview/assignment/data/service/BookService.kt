package com.example.android.preinterview.assignment.data.service

import com.example.android.preinterview.assignment.data.AppDatabase
import com.example.android.preinterview.assignment.data.vo.ApiVO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookService @Inject constructor(
    private val apiService: ApiService,
    appDatabase: AppDatabase
) {

    private val bookmarkDao = appDatabase.bookmarkDao()
    private val historyDao = appDatabase.historyDao()

    suspend fun getBookDetail(isbn13: String): ApiVO.Book.Detail {
        val detail = apiService.getBookDetail(isbn13)

        insertHistory(detail)

        return detail
    }

    suspend fun getBookmarks() = bookmarkDao.findAll()

    suspend fun selectBookmark(isbn13: String): ApiVO.Bookmark? = bookmarkDao.findById(isbn13)

    suspend fun insertBookmark(detail: ApiVO.Book.Detail?) {
        detail?.run {
            bookmarkDao.save(
                ApiVO.Bookmark(
                    isbn13 = isbn13,
                    title = title,
                    image = image
                )
            )
        }
    }

    suspend fun deleteBookmark(bookmark: ApiVO.Bookmark) {
        bookmarkDao.delete(bookmark)
    }

    suspend fun getHistories() = historyDao.findAll()

    suspend fun insertHistory(detail: ApiVO.Book.Detail) {
        historyDao.save(
            ApiVO.History(
                isbn13 = detail.isbn13,
                title = detail.title,
                image = detail.image
            )
        )
    }
}