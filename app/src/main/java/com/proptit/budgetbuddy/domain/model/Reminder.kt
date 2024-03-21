package com.proptit.budgetbuddy.domain.model

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.Locale

data class Reminder(
    val id: Int = 0,
    val userId: Int,
    val time: Time,
    val content: String,
    var isActive: Boolean
) {
    fun getTime(): String {
        val formatter = SimpleDateFormat("HH:mm", Locale.US)
        return formatter.format(time.time)
    }

    fun getHour(): Int {
        val formatter = SimpleDateFormat("HH", Locale.US)
        return formatter.format(time.time).toInt()
    }

    fun getMinute(): Int {
        val formatter = SimpleDateFormat("mm", Locale.US)
        return formatter.format(time.time).toInt()
    }

    fun getRepeat(): String {
        val builder = StringBuilder()
        builder.append(" Mon")
        builder.append(" Tue")
        builder.append(" Wed")
        builder.append(" Thu")
        builder.append(" Fri")
        builder.append(" Sat")
        builder.append(" Sun")
        return builder.toString()
    }
}