package com.proptit.budgetbuddy.data.source.local.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "reminders")

data class ReminderEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "hour")
    val hour: Int,
    @ColumnInfo(name = "minute")
    val minute: Int,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo val mon: Boolean,
    @ColumnInfo val tue: Boolean,
    @ColumnInfo val wed: Boolean,
    @ColumnInfo val thu: Boolean,
    @ColumnInfo val fri: Boolean,
    @ColumnInfo val sat: Boolean,
    @ColumnInfo val sun: Boolean,
    @ColumnInfo(name = "isActive")
    val isActive: Boolean
)