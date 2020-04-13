package com.example.android.preinterview.assignment.comp.retrofit

import com.example.android.preinterview.assignment.data.vo.ApiVO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/1.0/new")
    suspend fun getNew(): ApiVO.New.Response

    @GET("/1.0/books/{isbn13}")
    suspend fun getBookDetail(
        @Path("isbn13") isbn13: String
    ): ApiVO.Book.Detail

    @GET("/1.0/search/{query}/{page}")
    suspend fun getSearch(
        @Path("query") query: String,
        @Path("page") page: Int
    ): ApiVO.Search.Response
}