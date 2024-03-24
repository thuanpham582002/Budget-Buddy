package com.proptit.data.source.local.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "reminders")

data class ReminderEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "time")
    val time: Time,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "isActive")
    val isActive: Boolean
)