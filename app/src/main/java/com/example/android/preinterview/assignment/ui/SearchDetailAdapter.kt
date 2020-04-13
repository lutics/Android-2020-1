package com.example.android.preinterview.assignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.preinterview.assignment.data.vo.ApiVO
import com.example.android.preinterview.assignment.databinding.SearchDetailListItemBinding

class SearchDetailAdapter(
    private val searchDetailViewModel: SearchDetailViewModel
) : PagedListAdapter<ApiVO.Search.Response.Book, SearchDetailAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<ApiVO.Search.Response.Book>() {
        override fun areItemsTheSame(
            oldItem: ApiVO.Search.Response.Book,
            newItem: ApiVO.Search.Response.Book
        ): Boolean = oldItem.isbn13 == newItem.isbn13

        override fun areContentsTheSame(
            oldItem: ApiVO.Search.Response.Book,
            newItem: ApiVO.Search.Response.Book
        ): Boolean = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder.ItemViewHolder(
            SearchDetailListItemBinding.inflate(inflater, parent, false).apply { viewModel = searchDetailViewModel }
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.ItemViewHolder -> holder.bind(getItem(position))
        }
    }

    sealed class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        class ItemViewHolder(
            private val binding: SearchDetailListItemBinding
        ) : ViewHolder(binding.root) {

            fun bind(book: ApiVO.Search.Response.Book?) {
                book?.run {
                    binding.book = book
                    binding.executePendingBindings()
                }
            }
        }
    }
}