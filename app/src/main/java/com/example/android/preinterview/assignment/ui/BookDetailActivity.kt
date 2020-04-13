package com.example.android.preinterview.assignment.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import com.example.android.preinterview.assignment.R
import com.example.android.preinterview.assignment.databinding.BookDetailActivityBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.book_detail_activity.*
import javax.inject.Inject

class BookDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: BookDetailViewModel by viewModels { viewModelFactory }

    private val args: BookDetailActivityArgs by navArgs()

    private lateinit var binding: BookDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.book_detail_activity)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        viewModel.args.postValue(args)
    }
}