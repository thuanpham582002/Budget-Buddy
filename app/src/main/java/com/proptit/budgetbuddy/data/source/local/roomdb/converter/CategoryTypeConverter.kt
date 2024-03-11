package com.proptit.budgetbuddy.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import com.proptit.budgetbuddy.domain.model.CategoryType

class CategoryTypeConverter {

    @TypeConverter
    fun toCategoryType(value: Byte): CategoryType{
        return enumValues<CategoryType>()[value.toInt()]
    }

    @TypeConverter
    fun fromCategoryType(categoryType: CategoryType): Byte{
        return categoryType.value
    }
}