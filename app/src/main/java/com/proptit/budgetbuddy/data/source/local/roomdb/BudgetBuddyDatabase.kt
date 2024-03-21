package com.proptit.budgetbuddy.data.source.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.proptit.budgetbuddy.BuildConfig
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.data.source.local.roomdb.converter.CategoryTypeConverter
import com.proptit.budgetbuddy.data.source.local.roomdb.converter.DateConverter
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.CategoryDao
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.UserDao
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.UserEntity
import com.proptit.budgetbuddy.presentation.util.DatabaseQueryExecutor

@Database(
    entities = [UserEntity::class, CategoryEntity::class],
    version = 1
)
@TypeConverters(DateConverter::class, CategoryTypeConverter::class)
abstract class BudgetBuddyDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val categoryDao: CategoryDao

    companion object {
        const val DATABASE_NAME = "BudgetBuddyDatabase.db"
        val callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL("INSERT INTO users (name, date_of_birth, email, avatar_url, balance) VALUES ('Example', '1041354000', 'example@gmail.com', '', 0)")
                DatabaseQueryExecutor.executeDefaultCategory(db)
            }
        }
    }
}