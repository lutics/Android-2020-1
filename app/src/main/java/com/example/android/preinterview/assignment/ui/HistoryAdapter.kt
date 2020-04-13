package com.example.android.preinterview.assignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.preinterview.assignment.data.vo.ApiVO
import com.example.android.preinterview.assignment.databinding.HistoryListItemBinding

class HistoryAdapter(
    private val historyViewModel: HistoryViewModel
) : ListAdapter<ApiVO.History, HistoryAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<ApiVO.History>() {
        override fun areItemsTheSame(
            oldItem: ApiVO.History,
            newItem: ApiVO.History
        ): Boolean = oldItem.isbn13 == newItem.isbn13

        override fun areContentsTheSame(
            oldItem: ApiVO.History,
            newItem: ApiVO.History
        ): Boolean = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder.ItemViewHolder(
            HistoryListItemBinding.inflate(inflater, parent, false).apply { viewModel = historyViewModel }
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
            private val binding: HistoryListItemBinding
        ) : ViewHolder(binding.root) {

            fun bind(history: ApiVO.History) {
                binding.history = history
                binding.executePendingBindings()
            }
        }
    }
}