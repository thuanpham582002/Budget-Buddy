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
                initDefaultCategories(db)
            }
        }

        fun initDefaultCategories(db: SupportSQLiteDatabase) {
            val path = "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Food', '$path${R.drawable.ic_food}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Rice', '$path${R.drawable.ic_rice}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Traffic', '$path${R.drawable.ic_bus}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Social', '$path${R.drawable.ic_champagne}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Residential', '$path${R.drawable.ic_home}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Gift', '$path${R.drawable.ic_gift}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Communicate', '$path${R.drawable.ic_phone}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Clothes', '$path${R.drawable.ic_clothes}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Beautify', '$path${R.drawable.ic_haircut}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Medical', '$path${R.drawable.ic_medical}', 0)")
            db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Bonus', '$path${R.drawable.ic_moneybag}', 1)")
        }
    }

}