package com.proptit.data.mapper

import com.proptit.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.domain.model.Category

object CategoryMapper {

    fun toCategoryEntity(category: Category): CategoryEntity {
        return CategoryEntity(
            id = category.id,
            userId = category.userId,
            name = category.name,
            iconUrl = category.iconUrl,
            type = category.type
        )
    }

    fun toCategory(categoryEntity: CategoryEntity): Category {
        return Category(
            id = categoryEntity.id,
            userId = categoryEntity.userId,
            name = categoryEntity.name,
            iconUrl = categoryEntity.iconUrl,
            type = categoryEntity.type
        )
    }
}