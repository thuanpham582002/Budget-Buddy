package com.proptit.budgetbuddy.domain.repository

import com.proptit.budgetbuddy.domain.model.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderRepository {
    suspend fun insertReminder(reminder: Reminder)
    suspend fun updateReminder(reminder: Reminder)
    suspend fun deleteReminder(reminder: Reminder)
    fun getAllReminders(): Flow<List<Reminder>>

    suspend fun getReminderById(id: Int): Reminder
}