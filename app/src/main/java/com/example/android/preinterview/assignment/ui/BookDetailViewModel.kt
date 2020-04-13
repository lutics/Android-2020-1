package com.example.android.preinterview.assignment.ui

import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.example.android.preinterview.assignment.data.service.BookService
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookDetailViewModel @Inject constructor(
    private val bookService: BookService
) : ViewModel() {

    val args = MutableLiveData<BookDetailActivityArgs>()

    val detail = args.switchMap { liveData { emit(bookService.getBookDetail(it.isbn13)) } }

    fun insertBookmark(v: View) {
        viewModelScope.launch {
            detail.value?.run {
                val bookmark = bookService.selectBookmark(isbn13)
                if (bookmark == null) {
                    bookService.insertBookmark(this)

                    Toast.makeText(v.context, "Bookmarked", Toast.LENGTH_SHORT).show()
                } else {
                    bookService.deleteBookmark(bookmark)

                    Toast.makeText(v.context, "Deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}