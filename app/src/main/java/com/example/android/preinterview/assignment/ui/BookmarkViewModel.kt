package com.example.android.preinterview.assignment.ui

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import com.example.android.preinterview.assignment.R
import com.example.android.preinterview.assignment.data.service.BookService
import com.example.android.preinterview.assignment.data.vo.ApiVO
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val bookService: BookService
) : ViewModel() {

    val bookmarks = liveData { emit(bookService.getBookmarks()) }

    fun onItemClick(v: View, bookmark: ApiVO.Bookmark) {
        v.findNavController().navigate(R.id.action_bookmarkFragment_to_bookDetailActivity, BookDetailActivityArgs(bookmark.isbn13).toBundle())
    }
}