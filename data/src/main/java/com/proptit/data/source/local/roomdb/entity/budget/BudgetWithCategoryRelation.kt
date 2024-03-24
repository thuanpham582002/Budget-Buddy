package com.proptit.data.source.local.roomdb.entity.budget

import androidx.room.Embedded
import androidx.room.Relation
import com.proptit.data.source.local.roomdb.entity.CategoryEntity

data class BudgetWithCategoryRelation(
    @Embedded val budget: BudgetEntity,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "id"
    )
    val category: CategoryEntity
)