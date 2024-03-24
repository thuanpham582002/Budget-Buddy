package com.proptit.data.mapper

import com.proptit.data.source.local.roomdb.entity.budget.BudgetWithCategoryRelation
import com.proptit.domain.model.budget.BudgetWithCategory

fun BudgetWithCategoryRelation.toBudgetWithCategory(): BudgetWithCategory {
    return BudgetWithCategory(
        budget = budget.toBudget(),
        category = CategoryMapper.toCategory(category)
    )
}