package com.proptit.domain.repository

import com.proptit.domain.model.budget.Budget
import com.proptit.domain.model.budget.BudgetType
import com.proptit.domain.model.budget.BudgetWithCategory
import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    suspend fun updateBudget(budget: Budget)
    fun getAllBudgets(): Flow<List<Budget>>
    fun getBudgetsByType(budgetType: BudgetType): Flow<List<Budget>>
    suspend fun getBudgetById(id: Int): Budget
    fun getBudgetsWithCategoryByType(budgetType: BudgetType): Flow<List<BudgetWithCategory>>
    suspend fun getBudgetWithCategoryById(id: Int): BudgetWithCategory
}