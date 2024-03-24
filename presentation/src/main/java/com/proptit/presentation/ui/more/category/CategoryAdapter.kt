package com.proptit.presentation.ui.more.category

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.proptit.domain.model.Category
import com.proptit.presentation.databinding.ItemCategoryBinding
import com.proptit.presentation.util.AdapterAutoUpdatable
import com.zerobranch.layout.SwipeLayout

class CategoryAdapter(
    private val onItemClick: (Int) -> Unit,
    private val onDeleteClick: (Int) -> Unit
) :
    Adapter<CategoryAdapter.CategoryViewHolder>(), AdapterAutoUpdatable {
    private val categories = mutableListOf<Category>()

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        ViewHolder(binding.root) {
        init {
            binding.imageViewDelete.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onDeleteClick(categories[adapterPosition].id)
                    binding.itemCategorySwipe.close()
                }
            }
            binding.constraintLayoutCategoryItem.setOnClickListener {
                onItemClick(categories[adapterPosition].id)
            }

            binding.itemCategorySwipe.setOnActionsListener(object :
                SwipeLayout.SwipeActionsListener {
                override fun onOpen(direction: Int, isContinuous: Boolean) {
                    if (direction == SwipeLayout.LEFT && isContinuous) {
                        if (adapterPosition != RecyclerView.NO_POSITION) {
                            onDeleteClick(categories[adapterPosition].id)
                        }
                    }
                }

                override fun onClose() {}
            })
        }

        fun bind(category: Category) {
            binding.textViewCategoryName.text = category.name
            Glide.with(binding.root.context)
                .load(Uri.parse(category.iconUrl))
                .into(binding.imageViewCategoryItem)
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