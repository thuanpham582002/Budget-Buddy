package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.mapper.CategoryMapper
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.CategoryDao
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.model.CategoryType
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override suspend fun insertCategory(category: Category) {
        return withContext(Dispatchers.IO){
            categoryDao.insertCategory(CategoryMapper.toCategoryEntity(category))
        }
    }

    override suspend fun updateCategory(category: Category) {
        return withContext(Dispatchers.IO){
            categoryDao.updateCategory(CategoryMapper.toCategoryEntity(category))
        }
    }

    override suspend fun deleteCategory(category: Category) {
        return withContext(Dispatchers.IO){
            categoryDao.deleteCategory(CategoryMapper.toCategoryEntity(category))
        }
    }

    override suspend fun getCategoryByUserIdAndCategoryId(userId: Int, categoryId: Int): Category {
        return withContext(Dispatchers.IO){
            CategoryMapper.toCategory(categoryDao.getCategoryByUserIdAndCategoryId(userId, categoryId))
        }
    }

    override fun getAllCategoriesByType(categoryType: CategoryType): Flow<List<Category>> {
        return categoryDao.getAllCategoriesByType(categoryType).map {
            it.map { categoryEntity -> CategoryMapper.toCategory(categoryEntity) }
        }
    }


}