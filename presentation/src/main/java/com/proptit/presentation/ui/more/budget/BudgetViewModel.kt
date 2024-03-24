package com.proptit.presentation.ui.more.budget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.domain.model.budget.BudgetType
import com.proptit.domain.model.budget.BudgetWithCategory
import com.proptit.domain.repository.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository
) : ViewModel() {
    private val _budgetsWithCategoryByType = MutableStateFlow<List<BudgetWithCategory>>(emptyList())
    val budgetsWithCategoryByType = _budgetsWithCategoryByType.asStateFlow()

    fun getBudgetsWithCategoryByType(budgetType: BudgetType) {
        viewModelScope.launch(Dispatchers.IO) {
            budgetRepository.getBudgetsWithCategoryByType(budgetType)
                .collect { budgetsWithCategory ->
                    _budgetsWithCategoryByType.update {
                        budgetsWithCategory
                    }
                }
        }
    }
}