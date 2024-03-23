package com.proptit.budgetbuddy.domain.model.budget

import com.proptit.budgetbuddy.domain.model.Category

data class BudgetWithCategory(
    val budget: Budget,
    val category: Category
)