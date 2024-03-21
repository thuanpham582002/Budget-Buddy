package com.proptit.budgetbuddy.presentation.util

import androidx.sqlite.db.SupportSQLiteDatabase

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
}