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
                db.execSQL("INSERT INTO users (name, date_of_birth, email, avatar_url, balance) VALUES ('Example', '1041354000', 'example@gmail.com', '', 0)")
                val triggerInsertBudgetsAfterCategoryInsert = """
                    CREATE TRIGGER insert_budgets_after_category_insert
                    AFTER INSERT ON categories
                    WHEN NEW.type = 0
                    BEGIN
                    	INSERT INTO budgets(category_id, amount, type) VALUES (NEW.id, NULL, 0);
                    	INSERT INTO budgets(category_id, amount, type) VALUES (NEW.id, NULL, 1);
                    	INSERT INTO budgets(category_id, amount, type) VALUES (NEW.id, NULL, 2);
                    END
                """.trimIndent()
                db.execSQL(triggerInsertBudgetsAfterCategoryInsert)
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 1', '', 0)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 2', '', 0)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 3', '', 0)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 4', '', 1)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 5', '', 0)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 6', '', 1)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 7', '', 0)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 8', '', 1)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 9', '', 0)")
                db.execSQL("INSERT INTO categories (user_id, name, icon_url, type) VALUES (1, 'Category 10', '', 0)")
            }
        }
    }
}