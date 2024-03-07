package com.proptit.budgetbuddy.domain.model

import java.util.Date

data class User(
    val id: Int = 0,
    val name: String,
    val dateOfBirth: Date,
    val email: String,
    val avatarUrl: String,
    val balance: Int
)