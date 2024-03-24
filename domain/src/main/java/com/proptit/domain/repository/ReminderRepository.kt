package com.proptit.domain.repository

import com.proptit.domain.model.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderRepository {
    suspend fun insertReminder(reminder: Reminder)
    suspend fun updateReminder(reminder: Reminder)
    suspend fun deleteReminder(reminder: Reminder)
    fun getAllReminders(userId: Int): Flow<List<Reminder>>

    suspend fun getReminderById(id: Int, userId: Int): Reminder
}