package com.proptit.budgetbuddy.domain.repository

import com.proptit.budgetbuddy.domain.model.Budget
import com.proptit.budgetbuddy.domain.model.BudgetType
import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    suspend fun updateBudget(budget: Budget)
    fun getAllBudgets(): Flow<List<Budget>>
    fun getBudgetsByType(budgetType: BudgetType): Flow<List<Budget>>
    suspend fun getBudgetById(id: Int): Budget
}