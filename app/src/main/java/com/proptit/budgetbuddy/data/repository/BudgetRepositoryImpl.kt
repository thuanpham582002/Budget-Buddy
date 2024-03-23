package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.mapper.toBudget
import com.proptit.budgetbuddy.data.mapper.toBudgetEntity
import com.proptit.budgetbuddy.data.mapper.toBudgetWithCategory
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.BudgetDao
import com.proptit.budgetbuddy.domain.model.budget.Budget
import com.proptit.budgetbuddy.domain.model.budget.BudgetType
import com.proptit.budgetbuddy.domain.model.budget.BudgetWithCategory
import com.proptit.budgetbuddy.domain.repository.BudgetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BudgetRepositoryImpl @Inject constructor(
    private val budgetDao: BudgetDao
) : BudgetRepository {
    override suspend fun updateBudget(budget: Budget) {
        budgetDao.updateBudget(budget.toBudgetEntity())
    }

    override fun getAllBudgets(): Flow<List<Budget>> {
        return budgetDao.getAllBudgets().map { allBudgets ->
            allBudgets.map { it.toBudget() }
        }
    }

    override fun getBudgetsByType(budgetType: BudgetType): Flow<List<Budget>> {
        return budgetDao.getBudgetsByType(budgetType).map { allBudgets ->
            allBudgets.map { it.toBudget() }
        }
    }

    override suspend fun getBudgetById(id: Int): Budget {
        return withContext(Dispatchers.IO) {
            budgetDao.getBudgetById(id).toBudget()
        }
    }

    override suspend fun getBudgetWithCategoryById(id: Int): BudgetWithCategory {
        return withContext(Dispatchers.IO) {
            budgetDao.getBudgetWithCategoryById(id).toBudgetWithCategory()
        }
    }

    override fun getBudgetsWithCategoryByType(budgetType: BudgetType): Flow<List<BudgetWithCategory>> {
        return budgetDao.getBudgetsWithCategoryByType(budgetType).map { budgetsWithCategory ->
            budgetsWithCategory.map { it.toBudgetWithCategory() }
        }
    }
}