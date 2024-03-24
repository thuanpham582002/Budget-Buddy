package com.proptit.data.mapper

import com.proptit.data.source.local.roomdb.entity.ReminderEntity
import com.proptit.domain.model.Reminder

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