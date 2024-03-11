package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.domain.model.Category

object CategoryMapper {

    fun toCategoryEntity(category: Category): CategoryEntity{
        return CategoryEntity(
            id = category.id,
            userId = category.userId,
            name = category.name,
            iconUrl = category.iconUrl,
            type = category.type
        )
    }

    fun toCategory(categoryEntity: CategoryEntity): Category{
        return Category(
            id = categoryEntity.id,
            userId = categoryEntity.userId,
            name = categoryEntity.name,
            iconUrl = categoryEntity.iconUrl,
            type = categoryEntity.type
        )
    }
}