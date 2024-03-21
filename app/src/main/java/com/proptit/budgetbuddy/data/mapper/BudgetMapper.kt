package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.BudgetEntity
import com.proptit.budgetbuddy.domain.model.Budget

fun Budget.toBudgetEntity(): BudgetEntity {
    return BudgetEntity(
        id = this.id,
        categoryId = this.categoryId,
        amount = this.amount,
        type = this.type
    )
}

fun BudgetEntity.toBudget(): Budget {
    return Budget(
        id = this.id,
        categoryId = this.categoryId,
        amount = this.amount,
        type = this.type
    )
}