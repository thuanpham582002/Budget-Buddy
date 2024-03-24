package com.proptit.data.source.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.proptit.data.source.local.roomdb.converter.BudgetTypeConverter
import com.proptit.data.source.local.roomdb.converter.CategoryTypeConverter
import com.proptit.data.source.local.roomdb.converter.DateConverter
import com.proptit.data.source.local.roomdb.converter.TimeConverter
import com.proptit.data.source.local.roomdb.dao.BudgetDao
import com.proptit.data.source.local.roomdb.dao.CategoryDao
import com.proptit.data.source.local.roomdb.dao.ReminderDao
import com.proptit.data.source.local.roomdb.dao.UserDao
import com.proptit.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.data.source.local.roomdb.entity.ReminderEntity
import com.proptit.data.source.local.roomdb.entity.UserEntity
import com.proptit.data.source.local.roomdb.entity.budget.BudgetEntity
import com.proptit.data.source.local.roomdb.util.DatabaseQueryExecutor

@Database(
    entities = [UserEntity::class, CategoryEntity::class, ReminderEntity::class, BudgetEntity::class],
    version = 1
)
@TypeConverters(
    DateConverter::class,
    CategoryTypeConverter::class,
    TimeConverter::class,
    BudgetTypeConverter::class
)
abstract class BudgetBuddyDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val categoryDao: CategoryDao
    abstract val reminderDao: ReminderDao
    abstract val budgetDao: BudgetDao

    companion object {
        const val DATABASE_NAME = "BudgetBuddyDatabase.db"
        val callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                DatabaseQueryExecutor.executeDefaultUser(db)
                DatabaseQueryExecutor.executeTriggerInsertBudgetsAfterCategoryInsert(db)
                DatabaseQueryExecutor.executeDefaultCategory(db)
            }
        }
    }
}