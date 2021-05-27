package com.example.orpilla_agoraph.adapter

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import androidx.recyclerview.widget.RecyclerView
import com.example.orpilla_agoraph.ProfileActivity
import com.example.orpilla_agoraph.databinding.UserCardBinding
import com.example.orpilla_agoraph.model.UserItem
import com.squareup.picasso.Picasso

class UserViewHolder(private val binding: UserCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserItem, onItemClickListener: UserListAdapter.OnItemClickListener? = null) {
        binding.username.text = item.login
        val avatarImg = binding.profileImage
        Picasso.with(binding.profileImage.context).load(item.avatarUrl).into(avatarImg)

        if ((adapterPosition + 1) % 4 == 0) {
            val myDrawable = avatarImg
            val matrixInvert = ColorMatrix().apply {
                set(
                    floatArrayOf(
                        -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
                        0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
                        0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
                        0.0f, 0.0f, 0.0f, 1.0f, 0.0f
                    )
                )
            }
            val filter = ColorMatrixColorFilter(matrixInvert)
            myDrawable.colorFilter = filter
            binding.profileImage.invalidate()

        }

        onItemClickListener?.let { listener ->
            binding.root.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}