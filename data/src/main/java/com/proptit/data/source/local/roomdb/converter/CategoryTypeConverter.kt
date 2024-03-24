package com.proptit.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import com.proptit.domain.model.CategoryType

class CategoryTypeConverter {

    @TypeConverter
    fun toCategoryType(value: Byte): CategoryType {
        return enumValues<CategoryType>()[value.toInt()]
    }

    @TypeConverter
    fun fromCategoryType(categoryType: CategoryType): Byte {
        return categoryType.value
    }
}