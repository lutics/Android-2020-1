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
import kotlinx.android.synthetic.main.new_fragment.view.*
import javax.inject.Inject

class NewFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: NewViewModel by viewModels { viewModelFactory }

    companion object {
        private lateinit var newAdapter: NewAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.new_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newAdapter = NewAdapter(viewModel)

        view.rvBooks.adapter = newAdapter
        view.rvBooks.itemAnimator = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.new.observe(viewLifecycleOwner, Observer {
            newAdapter.submitList(it.books)
        })
    }
}