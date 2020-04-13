package com.example.android.preinterview.assignment.data.service

import com.example.android.preinterview.assignment.comp.retrofit.ApiInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor(
    private val apiInterface: ApiInterface
) {

    suspend fun getNew() = apiInterface.getNew()

    suspend fun getBookDetail(isbn13: String) = apiInterface.getBookDetail(isbn13)

    suspend fun getSearch(query: String, page: Int) = apiInterface.getSearch(query, page)
}