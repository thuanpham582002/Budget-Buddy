package com.proptit.budgetbuddy.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.domain.model.CategoryType
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryEntity: CategoryEntity)

    @Update
    suspend fun updateCategory(categoryEntity: CategoryEntity)

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoryEntity)

    @Query("SELECT * FROM categories WHERE user_id = :userId AND id = :categoryId")
    suspend fun getCategoryByUserIdAndCategoryId(userId: Int, categoryId: Int): CategoryEntity

    @Query("SELECT * FROM categories WHERE type = :categoryType")
    fun getAllCategoriesByType(categoryType: CategoryType): Flow<List<CategoryEntity>>

}