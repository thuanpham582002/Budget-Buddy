package com.proptit.budgetbuddy.presentation.ui.more.reminder.reminderList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.domain.model.Reminder
import com.proptit.budgetbuddy.domain.repository.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderListViewModel @Inject constructor(
    private val reminderRepository: ReminderRepository
) : ViewModel() {
    private val _allReminders = MutableStateFlow<List<Reminder>>(emptyList())
    val allReminders = _allReminders.asStateFlow()

    init{
        viewModelScope.launch(Dispatchers.IO){
            getAllReminders()
        }
    }

    private suspend fun getAllReminders() {
        reminderRepository.getAllReminders().collect { reminders ->
            _allReminders.update {
                reminders
            }
        }
    }

    fun addReminder(
        hour: Int,
        minute: Int,
        content: String,
        mon: Boolean,
        tue: Boolean,
        wed: Boolean,
        thu: Boolean,
        fri: Boolean,
        sat: Boolean,
        sun: Boolean,
        isActive: Boolean
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.insertReminder(
                Reminder(
                    hour = hour,
                    minute = minute,
                    content = content,
                    mon = mon,
                    tue = tue,
                    wed = wed,
                    thu = thu,
                    fri = fri,
                    sat = sat,
                    sun = sun,
                    isActive = isActive
                )
            )
        }
    }

    fun updateReminder(
        reminder: Reminder, isActive: Boolean
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.updateReminder(
                Reminder(
                    id = reminder.id,
                    hour = reminder.hour,
                    minute = reminder.minute,
                    content = reminder.content,
                    mon = reminder.mon,
                    tue = reminder.tue,
                    wed = reminder.wed,
                    thu = reminder.thu,
                    fri = reminder.fri,
                    sat = reminder.sat,
                    sun = reminder.sun,
                    isActive = isActive
                )
            )
        }
    }

    fun deleteReminder(reminder: Reminder) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.deleteReminder(reminder)
        }
    }

    fun insertReminder(reminder: Reminder) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.insertReminder(reminder)
        }
    }
}