package com.proptit.data.source.local.sharedpref

import android.app.Application
import android.content.Context
import javax.inject.Inject

class BudgetBuddySharedPref @Inject constructor(
    private val context: Application
) {
    companion object {
        const val SHARED_PREF_NAME = "budget_buddy_shared_pref"
    }

    fun put(key: String, value: Int) {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putInt(key, value)
            apply()
        }
    }

    fun get(key: String, defaultValue: Int): Int {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key, defaultValue)
    }
}