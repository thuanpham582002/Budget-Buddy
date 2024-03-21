package com.proptit.budgetbuddy.data.source.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.proptit.budgetbuddy.data.source.local.roomdb.converter.BudgetTypeConverter
import com.proptit.budgetbuddy.data.source.local.roomdb.converter.CategoryTypeConverter
import com.proptit.budgetbuddy.data.source.local.roomdb.converter.DateConverter
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.BudgetDao
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.CategoryDao
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.UserDao
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.BudgetEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.UserEntity
import com.proptit.budgetbuddy.presentation.util.DatabaseQueryExecutor

@Database(
    entities = [UserEntity::class, CategoryEntity::class, BudgetEntity::class],
    version = 1
)
@TypeConverters(DateConverter::class, BudgetTypeConverter::class, CategoryTypeConverter::class)
abstract class BudgetBuddyDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val budgetDao: BudgetDao
    abstract val categoryDao: CategoryDao

    companion object {
        const val DATABASE_NAME = "BudgetBuddyDatabase.db"
        val callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                DatabaseQueryExecutor.executeDefaultUser(db)
                DatabaseQueryExecutor.executeTriggerInsertBudgetsAfterCategoryInsert(db)
            }
        }
    }
}