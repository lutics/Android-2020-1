package com.example.android.preinterview.assignment.ui

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.android.preinterview.assignment.data.service.ApiService
import com.example.android.preinterview.assignment.data.vo.ApiVO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class SearchDetailDataSourceFactory(
    private val query: String,
    private val apiService: ApiService,
    override val coroutineContext: CoroutineContext
) : DataSource.Factory<Int, ApiVO.Search.Response.Book>(), CoroutineScope {

    override fun create(): DataSource<Int, ApiVO.Search.Response.Book> = object : PageKeyedDataSource<Int, ApiVO.Search.Response.Book>() {
        override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, ApiVO.Search.Response.Book>
        ) = runBlocking {
            val page = 0

            val response = apiService.getSearch(query, page)

            callback.onResult(response.books, null, page + 1)
        }

        override fun loadBefore(
            params: LoadParams<Int>,
            callback: LoadCallback<Int, ApiVO.Search.Response.Book>
        ) = runBlocking {
            Timber.e("loadBefore")
        }

        override fun loadAfter(
            params: LoadParams<Int>,
            callback: LoadCallback<Int, ApiVO.Search.Response.Book>
        ) = runBlocking {
            val page = params.key

            val response = apiService.getSearch(query, page)

            callback.onResult(response.books, page + 1)
        }
    }
}