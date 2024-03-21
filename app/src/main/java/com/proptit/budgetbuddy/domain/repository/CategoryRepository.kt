package com.proptit.budgetbuddy.domain.repository

import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.model.CategoryType
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun insertCategory(category: Category)
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(category: Category)
    suspend fun getCategoryByUserIdAndCategoryId(userId: Int, categoryId: Int): Category
    fun getAllCategoriesByType(categoryType: CategoryType): Flow<List<Category>>
}