package com.proptit.budgetbuddy.presentation.ui.more.reminder.reminderList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.snackbar.Snackbar
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentReminderListBinding
import com.proptit.budgetbuddy.domain.model.Reminder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReminderListFragment : Fragment() {
    private var _binding: FragmentReminderListBinding? = null
    private val binding get() = _binding!!
    private val reminderViewModel: ReminderListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReminderListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehaviour()
    }

    private fun initBehaviour() {
        initRecyclerViewReminder()
        onClickListener()
    }

    private fun initRecyclerViewReminder() {
        val reminderAdapter = ReminderAdapter(
            onItemClick(),
            onSwitchChanged()
        )
        binding.recyclerViewReminder.adapter = reminderAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            reminderViewModel.allReminders.collect {
                reminderAdapter.setReminders(it)
            }
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, target: androidx.recyclerview.widget.RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val reminder = reminderAdapter.getReminder(position)
                reminderViewModel.deleteReminder(reminder)
                view?.let {
                    Snackbar.make(it,"Reminder Deleted",Snackbar.LENGTH_LONG).apply {
                        setAction("UNDO"){
                            reminderViewModel.insertReminder(reminder)
                        }
                        show()
                    }
                }
            }
        }).attachToRecyclerView(binding.recyclerViewReminder)
    }

    private fun onSwitchChanged(): (Reminder, Boolean) -> Unit {
        return {reminder, isActive ->
            reminderViewModel.updateReminder(reminder, isActive)
        }
    }

    private fun onItemClick(): (Int) -> Unit {
        return {
            val bundle = bundleOf("reminderId" to it)
            findNavController().navigate(R.id.action_reminderListFragment_to_addReminderFragment, bundle)
        }
    }

    private fun onClickListener() {
        binding.textViewAdd.setOnClickListener {
            findNavController().navigate(R.id.action_reminderListFragment_to_addReminderFragment)
        }

        binding.appBarReminder.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}