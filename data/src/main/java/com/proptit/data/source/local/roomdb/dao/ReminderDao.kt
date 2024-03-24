package com.proptit.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.proptit.data.source.local.roomdb.entity.ReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    @Insert
    suspend fun insert(reminderEntity: ReminderEntity)

    @Update
    suspend fun update(reminderEntity: ReminderEntity)

    @Delete
    suspend fun delete(reminderEntity: ReminderEntity)

    @Query("SELECT * FROM reminders WHERE id = :id AND user_id = :userId")
    suspend fun getReminderById(id: Int, userId: Int): ReminderEntity

    @Query("SELECT * FROM reminders WHERE user_id = :userId")
    fun getAllReminder(userId: Int): Flow<List<ReminderEntity>>
}