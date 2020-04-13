package com.example.android.preinterview.assignment.ui

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.android.preinterview.assignment.R
import javax.inject.Inject

class SearchViewModel @Inject constructor(

) : ViewModel() {

    fun search(v: View, query: String) {
        v.findNavController().navigate(R.id.action_searchFragment_to_searchDetailFragment, SearchDetailFragmentArgs(query).toBundle())
    }
}