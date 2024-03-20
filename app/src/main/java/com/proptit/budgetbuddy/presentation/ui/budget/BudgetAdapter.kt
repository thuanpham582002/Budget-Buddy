package com.proptit.budgetbuddy.presentation.ui.budget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.proptit.budgetbuddy.databinding.ItemBudgetBinding
import com.proptit.budgetbuddy.domain.model.Budget
import com.proptit.budgetbuddy.presentation.util.AdapterAutoUpdatable

// TODO: All commented code is related to category, which is not implemented yet
class BudgetAdapter(
    private val onItemClick: (Int) -> Unit,
//    private val getCategoryById: (Int) -> Category
) : Adapter<BudgetAdapter.BudgetViewHolder>(), AdapterAutoUpdatable {
    private val budgets = mutableListOf<Budget>()

    inner class BudgetViewHolder(private val binding: ItemBudgetBinding) :
        ViewHolder(binding.root) {
        fun bind(budget: Budget) {
//            val category = getCategoryById(budget.categoryId)
            binding.apply {
                root.setOnClickListener {
                    onItemClick(budget.id)
                    root.background = null
                }
//                imageViewIcon.loadImage(Uri.parse((category.iconUrl))
//                textViewTitle.text = category.name
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
        return budgets.size
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.bind(budgets[position])
    }

    fun setBudgets(newBudgets: List<Budget>) {
        autoNotify(
            oldList = budgets,
            newList = newBudgets,
            compare = { old, new -> old.id == new.id }
        )
        budgets.clear()
        budgets.addAll(newBudgets)
    }
}