package com.example.android.preinterview.assignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.preinterview.assignment.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.history_fragment.*
import javax.inject.Inject

class HistoryFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HistoryViewModel by viewModels { viewModelFactory }

    companion object {
        private lateinit var historyAdapter: HistoryAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.history_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyAdapter = HistoryAdapter(viewModel)

        rvHistory.adapter = historyAdapter
        rvHistory.itemAnimator = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.histories.observe(viewLifecycleOwner, Observer {
            historyAdapter.submitList(it)
        })
    }
}