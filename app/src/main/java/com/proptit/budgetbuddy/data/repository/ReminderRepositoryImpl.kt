package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.mapper.ReminderMapper
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.ReminderDao
import com.proptit.budgetbuddy.domain.model.Reminder
import com.proptit.budgetbuddy.domain.repository.ReminderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReminderRepositoryImpl @Inject constructor(
    private val reminderDao: ReminderDao
): ReminderRepository{
    override suspend fun insertReminder(reminder: Reminder) {
        return withContext(Dispatchers.IO){
            reminderDao.insert(ReminderMapper().toReminderEntity(reminder))
        }
    }

    override suspend fun updateReminder(reminder: Reminder) {
        return withContext(Dispatchers.IO){
            reminderDao.update(ReminderMapper().toReminderEntity(reminder))
        }
    }

    override suspend fun deleteReminder(reminder: Reminder) {
        return withContext(Dispatchers.IO){
            reminderDao.delete(ReminderMapper().toReminderEntity(reminder))
        }
    }

    override suspend fun getReminderById(id: Int): Reminder {
        return withContext(Dispatchers.IO){
            ReminderMapper().toReminder(reminderDao.getReminderById(id))
        }
    }

    override fun getAllReminders(): Flow<List<Reminder>> {
        return reminderDao.getAllReminder().map { allReminders ->
            allReminders.map { ReminderMapper().toReminder(it) }
        }
    }

}