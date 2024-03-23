package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.budget.BudgetWithCategoryRelation
import com.proptit.budgetbuddy.domain.model.budget.BudgetWithCategory

fun BudgetWithCategoryRelation.toBudgetWithCategory(): BudgetWithCategory {
    return BudgetWithCategory(
        budget = budget.toBudget(),
        category = CategoryMapper.toCategory(category)
    )
}