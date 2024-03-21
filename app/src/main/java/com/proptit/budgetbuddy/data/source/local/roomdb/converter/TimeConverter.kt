package com.proptit.budgetbuddy.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import java.sql.Time

class TimeConverter {
    @TypeConverter
    fun fromTime(time: Time): Long {
        return time.time
    }

    @TypeConverter
    fun toTime(millisSinceEpoch: Long): Time {
        return Time(millisSinceEpoch)
    }
}