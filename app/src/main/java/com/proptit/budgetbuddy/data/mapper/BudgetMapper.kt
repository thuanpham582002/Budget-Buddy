package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.BudgetEntity
import com.proptit.budgetbuddy.domain.model.Budget

object BudgetMapper {
    fun toBudgetEntity(budget: Budget): BudgetEntity {
        return BudgetEntity(
            id = budget.id,
            categoryId = budget.categoryId,
            amount = budget.amount,
            type = budget.type
        )
    }

    fun toBudget(budgetEntity: BudgetEntity): Budget {
        return Budget(
            id = budgetEntity.id,
            categoryId = budgetEntity.categoryId,
            amount = budgetEntity.amount,
            type = budgetEntity.type
        )
    }
}