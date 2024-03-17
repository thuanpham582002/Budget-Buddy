package com.proptit.budgetbuddy.presentation.ui.more.category

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.proptit.budgetbuddy.databinding.ItemCategoryBinding
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.presentation.util.AdapterAutoUpdatable

class CategoryAdapter(private val onItemClick: (Int) -> Unit) :
    Adapter<CategoryAdapter.CategoryViewHolder>(), AdapterAutoUpdatable {
    private val categories = mutableListOf<Category>()

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.textViewCategoryName.text = category.name
            Glide.with(binding.root.context)
                .load(Uri.parse(category.iconUrl))
                .into(binding.imageViewCategoryItem)
            binding.root.setOnClickListener {
                onItemClick(category.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        Log.d("CategoryAdapter", "getItemCount: ${categories.size}")
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    fun setCategories(categories: List<Category>) {
        autoNotify(
            oldList = this.categories,
            newList = categories,
            compare = { old, new -> old.id == new.id }
        )
        this.categories.clear()
        this.categories.addAll(categories)
    }

}