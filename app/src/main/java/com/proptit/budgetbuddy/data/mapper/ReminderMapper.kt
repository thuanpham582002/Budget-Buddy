package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.CategoryEntity
import com.proptit.budgetbuddy.data.source.local.roomdb.entity.ReminderEntity
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.model.Reminder

object ReminderMapper {
    fun toReminderEntity(reminder: Reminder): ReminderEntity {
        return ReminderEntity(
            id = reminder.id,
            userId = reminder.userId,
            time = reminder.time,
            content = reminder.content,
            isActive = reminder.isActive
        )
    }

    fun toReminder(reminderEntity: ReminderEntity): Reminder {
        return Reminder(
            id = reminderEntity.id,
            userId = reminderEntity.userId,
            time = reminderEntity.time,
            content = reminderEntity.content,
            isActive = reminderEntity.isActive
        )
    }
}