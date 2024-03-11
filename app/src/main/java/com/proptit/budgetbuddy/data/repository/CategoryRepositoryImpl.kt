package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.source.local.roomdb.dao.CategoryDao
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {
}