package com.example.android.preinterview.assignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.preinterview.assignment.data.vo.ApiVO
import com.example.android.preinterview.assignment.databinding.BookmarkListItemBinding

class BookmarkAdapter(
    private val bookmarkViewModel: BookmarkViewModel
) : ListAdapter<ApiVO.Bookmark, BookmarkAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<ApiVO.Bookmark>() {
        override fun areItemsTheSame(
            oldItem: ApiVO.Bookmark,
            newItem: ApiVO.Bookmark
        ): Boolean = oldItem.isbn13 == newItem.isbn13

        override fun areContentsTheSame(
            oldItem: ApiVO.Bookmark,
            newItem: ApiVO.Bookmark
        ): Boolean = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder.ItemViewHolder(
            BookmarkListItemBinding.inflate(inflater, parent, false).apply { viewModel = bookmarkViewModel }
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
            private val binding: BookmarkListItemBinding
        ) : ViewHolder(binding.root) {

            fun bind(bookmark: ApiVO.Bookmark) {
                binding.bookmark = bookmark
                binding.executePendingBindings()
            }
        }
    }
}