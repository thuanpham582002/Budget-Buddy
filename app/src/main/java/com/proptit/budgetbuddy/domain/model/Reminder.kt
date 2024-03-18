package com.proptit.budgetbuddy.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.lang.StringBuilder

data class Reminder(
    val id: Int = 0,
    val hour: Int,
    val minute: Int,
    val content: String,
    val mon: Boolean,
    val tue: Boolean,
    val wed: Boolean,
    val thu: Boolean,
    val fri: Boolean,
    val sat: Boolean,
    val sun: Boolean,
    var isActive: Boolean
){
    fun getTime(): String{
        return String.format("%02d:%02d", hour, minute)
    }

    fun getRepeat(): String{
        val builder = StringBuilder()
        if (mon) builder.append(" Mon")
        if (tue) builder.append(" Tue")
        if (wed) builder.append(" Wed")
        if (thu) builder.append(" Thu")
        if (fri) builder.append(" Fri")
        if (sat) builder.append(" Sat")
        if (sun) builder.append(" Sun")
        return builder.toString()
    }
}