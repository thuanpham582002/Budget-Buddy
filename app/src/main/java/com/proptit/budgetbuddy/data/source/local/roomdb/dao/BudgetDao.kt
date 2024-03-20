package com.proptit.budgetbuddy.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.BudgetEntity
import com.proptit.budgetbuddy.domain.model.BudgetType
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Update
    suspend fun updateBudget(budget: BudgetEntity)

    @Query("SELECT * FROM budgets")
    fun getAllBudgets(): Flow<List<BudgetEntity>>

    @Query("SELECT * FROM budgets WHERE type = :budgetType")
    fun getBudgetsByType(budgetType: BudgetType): Flow<List<BudgetEntity>>

    @Query("SELECT * FROM budgets WHERE id = :id")
    suspend fun getBudgetById(id: Int): BudgetEntity
}