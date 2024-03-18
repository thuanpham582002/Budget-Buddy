package com.proptit.budgetbuddy.presentation.ui.more.reminder.reminderList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.proptit.budgetbuddy.databinding.ItemReminderBinding
import com.proptit.budgetbuddy.domain.model.Reminder
import com.proptit.budgetbuddy.presentation.util.AdapterAutoUpdatable

class ReminderAdapter (
    private val onItemClick: (Int) -> Unit,
    private val onSwitchChanged: (Reminder, Boolean) -> Unit
): Adapter<ReminderAdapter.ReminderViewHolder>(), AdapterAutoUpdatable{
    private val reminders = mutableListOf<Reminder>()
    inner class ReminderViewHolder(private val binding: ItemReminderBinding): ViewHolder(binding.root){
        fun bind(reminder: Reminder){
            binding.textViewTime.text = reminder.getTime()
            binding.textViewRepeat.text = reminder.getRepeat()
            binding.switchIsActive.isChecked = reminder.isActive
            binding.root.setOnClickListener {
                onItemClick(reminder.id)
            }
            binding.switchIsActive.setOnClickListener{
                onSwitchChanged(reminder, !reminder.isActive)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        return ReminderViewHolder(
            ItemReminderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return reminders.size
    }


    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        holder.bind(reminders[position])
    }

    fun getReminder(position: Int): Reminder{
        return reminders[position]
    }

    fun setReminders(reminders: List<Reminder>){
        autoNotify(
            oldList = this.reminders,
            newList = reminders,
            compare = { old, new -> old.id == new.id }
        )
        this.reminders.clear()
        this.reminders.addAll(reminders)
    }
}