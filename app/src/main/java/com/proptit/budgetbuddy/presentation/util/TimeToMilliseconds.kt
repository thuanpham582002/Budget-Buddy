package com.proptit.budgetbuddy.presentation.util

object TimeConverter {
    fun timeToMilliseconds(hour: Int, minute: Int): Long {
        return ((hour * 3600 + minute * 60 - 25200) * 1000).toLong()
    }
}