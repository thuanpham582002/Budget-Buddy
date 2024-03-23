package com.proptit.budgetbuddy.domain.model.budget

data class Budget(
    val id: Int = 0,
    val categoryId: Int,
    val amount: Int? = null,
    val type: BudgetType
)