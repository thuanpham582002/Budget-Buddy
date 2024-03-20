package com.proptit.budgetbuddy.data.source.local.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.proptit.budgetbuddy.domain.model.BudgetType

@Entity(
    tableName = "budgets",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BudgetEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    @ColumnInfo(name = "amount")
    val amount: Int? = null,
    @ColumnInfo(name = "type")
    val type: BudgetType
)