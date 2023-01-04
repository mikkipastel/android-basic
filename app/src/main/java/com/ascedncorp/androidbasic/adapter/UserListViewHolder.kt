package com.ascedncorp.androidbasic.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ascedncorp.androidbasic.databinding.ItemShowUserAdapterBinding
import com.ascedncorp.androidbasic.model.DataItem
import com.bumptech.glide.Glide

class UserListViewHolder(
    private val binding: ItemShowUserAdapterBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DataItem) {
        binding.apply {
            Glide.with(root.context)
                .load(item.avatar)
                .into(imgAvatar)
            textName.text = "${item.firstName} ${item.lastName}"
            textEmail.text = item.email
        }
    }
}
