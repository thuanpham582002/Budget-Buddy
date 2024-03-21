package com.proptit.budgetbuddy.presentation.ui.more.category

import android.graphics.drawable.Icon
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proptit.budgetbuddy.databinding.ItemCategoryIconBinding
import com.proptit.budgetbuddy.databinding.ItemSectionHeaderBinding
import com.proptit.budgetbuddy.domain.model.IconSection
import com.proptit.budgetbuddy.presentation.util.AdapterAutoUpdatable
import com.shuhart.stickyheader.StickyAdapter

//class CategoryIconAdapter(private val onItemClick: (String) -> Unit) :
//    RecyclerView.Adapter<CategoryIconAdapter.CategoryIconViewHolder>(), AdapterAutoUpdatable {
//    private val categoryIcons = mutableListOf<String>()
//
//    inner class CategoryIconViewHolder(private val binding: ItemCategoryIconBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(iconUrl: String) {
//            Glide.with(itemView.context).load(Uri.parse(iconUrl)).into(binding.imageViewIcon)
//            binding.root.setOnClickListener {
//                onItemClick(iconUrl)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryIconViewHolder {
//        return CategoryIconViewHolder(
//            ItemCategoryIconBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return categoryIcons.size
//    }
//
//    override fun onBindViewHolder(holder: CategoryIconViewHolder, position: Int) {
//        holder.bind(categoryIcons[position])
//    }
//
//    fun setCategoryIcons(categoryIcons: List<String>) {
//        autoNotify(
//            oldList = this.categoryIcons,
//            newList = categoryIcons,
//            compare = { old, new -> old == new }
//        )
//        this.categoryIcons.clear()
//        this.categoryIcons.addAll(categoryIcons)
//    }
//}

class CategoryIconAdapter(private val onItemClick: (String) -> Unit) :
    StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>(), AdapterAutoUpdatable {
    private val categoryIconsSectionList = mutableListOf<IconSection>()

    inner class HeaderViewHolder(private val binding: ItemSectionHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(headerTitle: String) {
            binding.textViewSectionHeader.text = headerTitle
        }
    }

    inner class ItemViewHolder(private val binding: ItemCategoryIconBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(iconUrl: String) {
            Glide.with(itemView.context).load(Uri.parse(iconUrl)).into(binding.imageViewIcon)
            binding.root.setOnClickListener {
                onItemClick(iconUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            IconSection.HEADER -> HeaderViewHolder(
                ItemSectionHeaderBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> ItemViewHolder(
                ItemCategoryIconBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return categoryIconsSectionList.size
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        return categoryIconsSectionList[itemPosition].sectionHeaderPosition()
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return createViewHolder(parent, IconSection.HEADER)
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, headerPosition: Int) {
        (holder as HeaderViewHolder).bind(categoryIconsSectionList[headerPosition].getAttribute())

        Log.d("CategoryIconAdapter", "onBindHeaderViewHolder: ${categoryIconsSectionList[headerPosition].getAttribute()}")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = categoryIconsSectionList[position].type()
        val attribute = categoryIconsSectionList[position].getAttribute()
        when (type){
            IconSection.HEADER -> (holder as HeaderViewHolder).bind(attribute)
            IconSection.ITEM -> (holder as ItemViewHolder).bind(attribute)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return categoryIconsSectionList[position].type()
    }

    fun setCategoryIcons(categoryIcons: List<IconSection>) {
        autoNotify(
            oldList = this.categoryIconsSectionList,
            newList = categoryIcons,
            compare = { old, new -> old == new }
        )
        this.categoryIconsSectionList.clear()
        this.categoryIconsSectionList.addAll(categoryIcons)
    }
}

