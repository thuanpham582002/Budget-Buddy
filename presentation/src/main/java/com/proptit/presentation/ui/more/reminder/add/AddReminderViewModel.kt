package com.proptit.presentation.ui.more.reminder.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.domain.model.Reminder
import com.proptit.domain.repository.ReminderRepository
import com.proptit.presentation.util.TimeConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.sql.Time
import javax.inject.Inject


@HiltViewModel
class AddReminderViewModel @Inject constructor(
    private val reminderRepository: ReminderRepository
) : ViewModel() {
    private val _reminder = MutableStateFlow<Reminder?>(null)
    val reminder = _reminder
    fun addReminder(
        hour: Int,
        minute: Int,
        content: String,
        isActive: Boolean
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.insertReminder(
                Reminder(
                    userId = 1,
                    time = Time(TimeConverter.timeToMilliseconds(hour, minute)),
                    content = content,
                    isActive = isActive
                )
            )
        }
    }

    fun setReminder(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _reminder.value = reminderRepository.getReminderById(id, 1)
        }
    }

    fun updateReminder(
        hour: Int,
        minute: Int,
        content: String,
        isActive: Boolean
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val reminder = _reminder.value!!
            reminderRepository.updateReminder(
                Reminder(
                    id = reminder.id,
                    userId = reminder.userId,
                    time = Time(TimeConverter.timeToMilliseconds(hour, minute)),
                    content = content,
                    isActive = isActive
                )
            )
        }
    }
}