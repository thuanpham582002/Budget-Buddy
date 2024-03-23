package com.proptit.budgetbuddy.presentation.util

import com.proptit.budgetbuddy.BuildConfig
import com.proptit.budgetbuddy.R

object Constant {
    const val BUDGET_ID = "budget_id"
    const val CATEGORY_ID = "category_id"
    const val CATEGORY_TYPE = "category_type"
    const val CURRENT_TAB_POSITION = "currentTabPosition"
    private val categoryIconLists = listOf<String>(
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_food}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_education}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_afro_pick}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_baguette}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_detective_hat}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_phone}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_art_prices}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/" + "${R.drawable.ic_bowling}",
    )

    fun getCategoryIconLists(): List<String> {
        return categoryIconLists.toList()
    }
}