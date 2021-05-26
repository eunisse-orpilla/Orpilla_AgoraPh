package com.example.orpilla_agoraph.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.orpilla_agoraph.databinding.UserCardBinding
import com.example.orpilla_agoraph.model.UserItem

class UserListAdapter(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<UserItem, UserViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        UserCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClickListener)

    interface OnItemClickListener {
        fun onItemClicked(item: UserItem)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserItem>() {
            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean =
                oldItem == newItem

        }
    }
}