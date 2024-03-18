package com.proptit.budgetbuddy.presentation.ui.more.reminder.addReminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.domain.model.Reminder
import com.proptit.budgetbuddy.domain.repository.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
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

    fun setReminder(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _reminder.value = reminderRepository.getReminderById(id)
        }
    }

    fun updateReminder(
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
            val reminder = _reminder.value!!
            reminderRepository.updateReminder(
                Reminder(
                    id = reminder.id,
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
}