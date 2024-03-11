package com.proptit.budgetbuddy.domain.model

data class Category(
    val id: Int = 0,
    val userId: Int,
    val name: String,
    val iconUrl: String,
    val type: CategoryType
)
