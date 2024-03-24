package com.proptit.domain.model.budget

import com.proptit.domain.model.Category

data class BudgetWithCategory(
    val budget: Budget,
    val category: Category
)