package com.example.android.preinterview.assignment.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

class ApiVO {

    class New {

        data class Response(
            val error: Int,
            val total: Int,
            val books: List<Book>
        ) {

            data class Book(
                val title: String,
                val subtitle: String,
                val isbn13: String,
                val price: String,
                val image: String,
                val url: String
            )
        }
    }

    class Search {

        data class Response(
            val error: Int,
            val total: Int,
            val books: List<Book>
        ) {

            data class Book(
                val title: String,
                val subtitle: String,
                val isbn13: String,
                val price: String,
                val image: String,
                val url: String
            )
        }
    }

    class Book {

        data class Detail(
            val error: Int,
            val title: String,
            val subtitle: String,
            val authors: String,
            val publisher: String,
            val language: String,
            val isbn10: String,
            val isbn13: String,
            val pages: String,
            val year: String,
            val rating: String,
            val desc: String,
            val price: String,
            val image: String,
            val url: String
        )
    }

    @Entity
    data class Bookmark(

        @PrimaryKey
        val isbn13: String,
        val title: String,
        val image: String
    )

    @Entity
    data class History(

        @PrimaryKey
        val isbn13: String,
        val title: String,
        val image: String
    )
}