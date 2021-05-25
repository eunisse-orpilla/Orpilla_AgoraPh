package com.example.orpilla_agoraph.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.orpilla_agoraph.databinding.UserCardBinding
import com.example.orpilla_agoraph.model.UserItem

class UserViewHolder(private val binding: UserCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserItem, onItemClickListener: UserListAdapter.OnItemClickListener? = null) {
        binding.profileImage.
        binding.username.text = item.login
    }
}