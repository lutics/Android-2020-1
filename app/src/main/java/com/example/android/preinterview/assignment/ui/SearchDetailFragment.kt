package com.example.android.preinterview.assignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.android.preinterview.assignment.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.search_detail_fragment.*
import javax.inject.Inject

class SearchDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SearchDetailViewModel by viewModels { viewModelFactory }

    private val args: SearchDetailFragmentArgs by navArgs()

    companion object {
        private lateinit var searchDetailAdapter: SearchDetailAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.search_detail_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchDetailAdapter = SearchDetailAdapter(viewModel)

        rvSearch.adapter = searchDetailAdapter
        rvSearch.itemAnimator = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.args.postValue(args)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            searchDetailAdapter.submitList(it)
        })
    }
}