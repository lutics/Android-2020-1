package com.example.android.preinterview.assignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.preinterview.assignment.data.vo.ApiVO
import com.example.android.preinterview.assignment.databinding.NewListItemBinding

class NewAdapter(
    private val newViewModel: NewViewModel
) : ListAdapter<ApiVO.New.Response.Book, NewAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<ApiVO.New.Response.Book>() {
        override fun areItemsTheSame(
            oldItem: ApiVO.New.Response.Book,
            newItem: ApiVO.New.Response.Book
        ): Boolean = oldItem.isbn13 == newItem.isbn13

        override fun areContentsTheSame(
            oldItem: ApiVO.New.Response.Book,
            newItem: ApiVO.New.Response.Book
        ): Boolean = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder.ItemViewHolder(
            NewListItemBinding.inflate(inflater, parent, false).apply { viewModel = newViewModel }
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
            private val binding: NewListItemBinding
        ) : ViewHolder(binding.root) {

            fun bind(book: ApiVO.New.Response.Book) {
                binding.book = book
                binding.executePendingBindings()
            }
        }
    }
}