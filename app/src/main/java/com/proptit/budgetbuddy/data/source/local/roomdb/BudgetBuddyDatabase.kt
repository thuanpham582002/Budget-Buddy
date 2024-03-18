package com.proptit.budgetbuddy.data.source.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.proptit.budgetbuddy.data.source.local.roomdb.converter.DateConverter
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.ReminderDao
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.UserDao
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.ReminderEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.UserEntity

@Database(
    entities = [UserEntity::class, CategoryEntity::class, ReminderEntity::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class BudgetBuddyDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val reminderDao: ReminderDao
    companion object {
        const val DATABASE_NAME = "BudgetBuddyDatabase.db"
        val callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL("INSERT INTO users (name, date_of_birth, email, avatar_url, balance) VALUES ('Example', '1041354000', 'example@gmail.com', '', 0)")
            }
        }
    }
}