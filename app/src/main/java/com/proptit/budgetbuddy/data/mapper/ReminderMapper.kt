package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.ReminderEntity
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.model.Reminder

class ReminderMapper {
    fun toReminderEntity(reminder: Reminder): ReminderEntity {
        return ReminderEntity(
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
            isActive = reminder.isActive
        )
    }

    fun toReminder(reminderEntity: ReminderEntity): Reminder {
        return Reminder(
            id = reminderEntity.id,
            hour = reminderEntity.hour,
            minute = reminderEntity.minute,
            content = reminderEntity.content,
            mon = reminderEntity.mon,
            tue = reminderEntity.tue,
            wed = reminderEntity.wed,
            thu = reminderEntity.thu,
            fri = reminderEntity.fri,
            sat = reminderEntity.sat,
            sun = reminderEntity.sun,
            isActive = reminderEntity.isActive
        )
    }
}