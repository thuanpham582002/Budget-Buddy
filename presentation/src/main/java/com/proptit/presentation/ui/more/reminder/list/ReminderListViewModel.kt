package com.proptit.presentation.ui.more.reminder.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.domain.model.Reminder
import com.proptit.domain.repository.AuthRepository
import com.proptit.domain.repository.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderListViewModel @Inject constructor(
    private val reminderRepository: ReminderRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _allReminders = MutableStateFlow<List<Reminder>>(emptyList())
    val allReminders = _allReminders.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllReminders()
        }
    }

    private suspend fun getAllReminders() {
        reminderRepository.getAllReminders(authRepository.getSignedInUserId())
            .collect { reminders ->
                _allReminders.update {
                    reminders
                }
            }
    }

    fun updateReminder(
        reminder: Reminder, isActive: Boolean
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.updateReminder(
                Reminder(
                    userId = authRepository.getSignedInUserId(),
                    id = reminder.id,
                    time = reminder.time,
                    content = reminder.content,
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