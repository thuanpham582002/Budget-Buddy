package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.mapper.BudgetMapper
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.BudgetDao
import com.proptit.budgetbuddy.domain.model.Budget
import com.proptit.budgetbuddy.domain.model.BudgetType
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
        budgetDao.updateBudget(BudgetMapper.toBudgetEntity(budget))
    }

    override fun getAllBudgets(): Flow<List<Budget>> {
        return budgetDao.getAllBudgets().map { allBudgets ->
            allBudgets.map { BudgetMapper.toBudget(it) }
        }
    }

    override fun getBudgetsByType(budgetType: BudgetType): Flow<List<Budget>> {
        return budgetDao.getBudgetsByType(budgetType).map { allBudgets ->
            allBudgets.map { BudgetMapper.toBudget(it) }
        }
    }

    override suspend fun getBudgetById(id: Int): Budget {
        return withContext(Dispatchers.IO) {
            BudgetMapper.toBudget(budgetDao.getBudgetById(id))
        }
    }
}