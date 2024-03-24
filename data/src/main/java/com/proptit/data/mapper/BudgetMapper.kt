package com.proptit.data.mapper

import com.proptit.data.source.local.roomdb.entity.budget.BudgetEntity
import com.proptit.domain.model.budget.Budget

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