package com.example.android.preinterview.assignment.ui

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import com.example.android.preinterview.assignment.R
import com.example.android.preinterview.assignment.data.service.BookService
import com.example.android.preinterview.assignment.data.vo.ApiVO
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val bookService: BookService
) : ViewModel() {

    val histories = liveData { emit(bookService.getHistories()) }

    fun onItemClick(v: View, history: ApiVO.History) {
        v.findNavController().navigate(R.id.action_historyFragment_to_bookDetailActivity, BookDetailActivityArgs(history.isbn13).toBundle())
    }
}