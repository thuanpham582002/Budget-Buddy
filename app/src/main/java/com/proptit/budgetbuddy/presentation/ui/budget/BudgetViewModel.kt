package com.proptit.budgetbuddy.presentation.ui.budget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.domain.model.Budget
import com.proptit.budgetbuddy.domain.model.BudgetType
import com.proptit.budgetbuddy.domain.repository.BudgetRepository
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {
    private val _budgetsByType = MutableStateFlow<List<Budget>>(emptyList())
    val budgetsByType = _budgetsByType.asStateFlow()

    fun getBudgetsByType(budgetType: BudgetType) {
        viewModelScope.launch(Dispatchers.IO) {
            budgetRepository.getBudgetsByType(budgetType).collect { budgets ->
                _budgetsByType.update {
                    budgets
                }
            }
        }
    }
}