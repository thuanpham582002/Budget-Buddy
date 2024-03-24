package com.proptit.presentation.ui.more.budget.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.domain.model.budget.Budget
import com.proptit.domain.model.budget.BudgetWithCategory
import com.proptit.domain.repository.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditBudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository
) : ViewModel() {
    private val _budgetWithCategory = MutableStateFlow<BudgetWithCategory?>(null)
    val budgetWithCategory = _budgetWithCategory.asStateFlow()

    fun saveBudget(amount: Int) {
        val budget = _budgetWithCategory.value!!.budget
        viewModelScope.launch(Dispatchers.IO) {
            budgetRepository.updateBudget(
                Budget(
                    id = budget.id,
                    amount = amount,
                    categoryId = budget.categoryId,
                    type = budget.type
                )
            )
        }
    }

    fun setBudgetWithCategory(budgetId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _budgetWithCategory.value = budgetRepository.getBudgetWithCategoryById(budgetId)
        }
    }
}