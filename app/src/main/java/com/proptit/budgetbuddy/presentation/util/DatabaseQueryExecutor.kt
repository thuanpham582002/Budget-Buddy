package com.proptit.budgetbuddy.presentation.util

import androidx.sqlite.db.SupportSQLiteDatabase
import com.proptit.budgetbuddy.BuildConfig
import com.proptit.budgetbuddy.R

object DatabaseQueryExecutor {
    fun executeDefaultUser(db: SupportSQLiteDatabase) {
        db.execSQL("INSERT INTO users (name, date_of_birth, email, avatar_url, balance) VALUES ('Example', '1041354000', 'example@gmail.com', '', 0)")
    }

    fun executeTriggerInsertBudgetsAfterCategoryInsert(db: SupportSQLiteDatabase) {
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
    }

    fun executeDefaultCategory(db: SupportSQLiteDatabase) {
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