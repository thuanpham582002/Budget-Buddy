package com.proptit.budgetbuddy.presentation.ui.budget.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.domain.model.Budget
import com.proptit.budgetbuddy.domain.repository.BudgetRepository
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditBudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {
    private val _budget = MutableStateFlow<Budget?>(null)
    val budget = _budget.asStateFlow()

    fun saveBudget(amount: Int) {
        val budget = _budget.value!!
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

    fun setBudget(budgetId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _budget.value = budgetRepository.getBudgetById(budgetId)
        }
    }
}