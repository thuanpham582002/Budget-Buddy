package com.proptit.presentation.ui.more.category

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proptit.presentation.databinding.ItemCategoryIconBinding
import com.proptit.presentation.util.AdapterAutoUpdatable

class CategoryIconAdapter(private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<CategoryIconAdapter.CategoryIconViewHolder>(), AdapterAutoUpdatable {
    private val categoryIcons = mutableListOf<String>()

    inner class CategoryIconViewHolder(private val binding: ItemCategoryIconBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(iconUrl: String) {
            Glide.with(itemView.context).load(Uri.parse(iconUrl)).into(binding.imageViewIcon)
            binding.root.setOnClickListener {
                onItemClick(iconUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryIconViewHolder {
        return CategoryIconViewHolder(
            ItemCategoryIconBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryIcons.size
    }

    override fun onBindViewHolder(holder: CategoryIconViewHolder, position: Int) {
        holder.bind(categoryIcons[position])
    }

    fun setCategoryIcons(categoryIcons: List<String>) {
        autoNotify(
            oldList = this.categoryIcons,
            newList = categoryIcons,
            compare = { old, new -> old == new }
        )
        this.categoryIcons.clear()
        this.categoryIcons.addAll(categoryIcons)
    }
}