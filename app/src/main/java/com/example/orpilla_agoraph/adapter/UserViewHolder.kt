package com.example.orpilla_agoraph.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.orpilla_agoraph.databinding.UserCardBinding
import com.example.orpilla_agoraph.model.UserItem
import com.squareup.picasso.Picasso

class UserViewHolder(private val binding: UserCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserItem, onItemClickListener: UserListAdapter.OnItemClickListener? = null){
        binding.username.text = item.login
        val avatarImg = binding.profileImage
        Picasso.with(binding.profileImage.context).load(item.avatarUrl).into(avatarImg)

        onItemClickListener?.let { listener ->
            binding.root.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}