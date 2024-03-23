package com.proptit.budgetbuddy.domain.model.budget

enum class BudgetType(val value: Byte) {
    WEEKLY(0),
    MONTHLY(1),
    ANNUALLY(2)
}