package com.proptit.budgetbuddy.data.source.local.roomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.ReminderEntity
import com.proptit.budgetbuddy.domain.model.Reminder
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    @Insert
    suspend fun insert(reminderEntity: ReminderEntity)

    @Update
    suspend fun update(reminderEntity: ReminderEntity)

    @Delete
    suspend fun delete(reminderEntity: ReminderEntity)
    @Query("SELECT * FROM reminders WHERE id = :id")
    suspend fun getReminderById(id: Int): ReminderEntity
    @Query("SELECT * FROM reminders")
    fun getAllReminder(): Flow<List<ReminderEntity>>
}