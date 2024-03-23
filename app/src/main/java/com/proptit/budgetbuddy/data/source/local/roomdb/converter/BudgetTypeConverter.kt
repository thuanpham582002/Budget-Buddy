package com.proptit.budgetbuddy.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import com.proptit.budgetbuddy.domain.model.budget.BudgetType

class BudgetTypeConverter {
    @TypeConverter
    fun toBudgetType(value: Byte): BudgetType {
        return enumValues<BudgetType>()[value.toInt()]
    }

    @TypeConverter
    fun fromBudgetType(budgetType: BudgetType): Byte {
        return budgetType.value
    }
}