package com.proptit.budgetbuddy.domain.model

interface IconSection {
    companion object {
        const val HEADER = 0
        const val ITEM = 1
    }

    fun type(): Int
    fun sectionHeaderPosition(): Int

    fun getAttribute(): String
}