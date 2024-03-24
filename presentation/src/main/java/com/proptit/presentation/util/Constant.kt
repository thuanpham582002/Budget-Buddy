package com.proptit.presentation.util

import com.proptit.common.R

object Constant {
    const val BUDGET_ID = "budget_id"
    const val CATEGORY_ID = "category_id"
    const val CATEGORY_TYPE = "category_type"
    const val CURRENT_TAB_POSITION = "currentTabPosition"
    private const val PATH = "com.proptit.budgetbuddy"
    private val categoryIconLists = listOf<String>(
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_food}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_education}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_afro_pick}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_baguette}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_detective_hat}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_phone}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_art_prices}",
        "android.resource://$PATH/drawable/" + "${R.drawable.ic_bowling}",
    )

    fun getCategoryIconLists(): List<String> {
        return categoryIconLists.toList()
    }
}