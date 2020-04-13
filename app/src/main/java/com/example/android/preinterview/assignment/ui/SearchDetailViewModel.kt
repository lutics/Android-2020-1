package com.example.android.preinterview.assignment.ui

import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.android.preinterview.assignment.R
import com.example.android.preinterview.assignment.data.service.ApiService
import com.example.android.preinterview.assignment.data.vo.ApiVO
import javax.inject.Inject

class SearchDetailViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    val args = MutableLiveData<SearchDetailFragmentArgs>()

    val data = args.switchMap {
        SearchDetailDataSourceFactory(it.query, apiService, viewModelScope.coroutineContext).toLiveData(
            config = Config(
                pageSize = 20,
                initialLoadSizeHint = 60
            )
        )
    }

    fun onItemClick(v: View, book: ApiVO.Search.Response.Book) {
        v.findNavController().navigate(R.id.action_searchDetailFragment_to_bookDetailActivity, BookDetailActivityArgs(book.isbn13).toBundle())
    }
}