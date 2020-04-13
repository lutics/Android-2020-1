package com.example.android.preinterview.assignment.ui

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import com.example.android.preinterview.assignment.R
import com.example.android.preinterview.assignment.data.service.ApiService
import com.example.android.preinterview.assignment.data.vo.ApiVO
import javax.inject.Inject

class NewViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    val new = liveData { emit(apiService.getNew()) }

    fun onItemClick(v: View, book: ApiVO.New.Response.Book) {
        v.findNavController().navigate(R.id.action_newFragment_to_bookDetailActivity,BookDetailActivityArgs(book.isbn13).toBundle())
    }
}