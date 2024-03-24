package com.proptit.presentation.ui.more.budget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.proptit.domain.model.budget.BudgetWithCategory
import com.proptit.presentation.databinding.ItemBudgetBinding
import com.proptit.presentation.util.AdapterAutoUpdatable
import com.proptit.presentation.util.loadImage

class BudgetAdapter(
    private val onItemClick: (Int) -> Unit
) : Adapter<BudgetAdapter.BudgetViewHolder>(), AdapterAutoUpdatable {
    private val budgetsWithCategory = mutableListOf<BudgetWithCategory>()

    inner class BudgetViewHolder(private val binding: ItemBudgetBinding) :
        ViewHolder(binding.root) {
        fun bind(budgetWithCategory: BudgetWithCategory) {
            val budget = budgetWithCategory.budget
            val category = budgetWithCategory.category
            binding.apply {
                root.setOnClickListener {
                    onItemClick(budget.id)
                    root.background = null
                }
                imageViewIcon.loadImage(category.iconUrl)
                textViewTitle.text = category.name
                textViewAmount.text = budget.amount?.toString() ?: "Not Set"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        return BudgetViewHolder(
            ItemBudgetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return budgetsWithCategory.size
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.bind(budgetsWithCategory[position])
    }

    fun setBudgetsWithCategory(newBudgetsWithCategory: List<BudgetWithCategory>) {
        autoNotify(
            oldList = budgetsWithCategory,
            newList = newBudgetsWithCategory,
            compare = { old, new -> old.budget.id == new.budget.id }
        )
        budgetsWithCategory.clear()
        budgetsWithCategory.addAll(newBudgetsWithCategory)
    }
}