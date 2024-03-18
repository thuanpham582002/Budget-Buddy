package com.proptit.budgetbuddy.presentation.ui.more.reminder.addReminder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.proptit.budgetbuddy.databinding.FragmentReminderDialogBinding

class ReminderDialogFragment : DialogFragment() {
    private var _binding: FragmentReminderDialogBinding? = null
    private val binding get()= _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReminderDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehaviour()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    private fun initBehaviour() {
        val adapter = ViewPagerAdapter(this)
        binding.viewPagerReminder.adapter = adapter
        TabLayoutMediator(binding.tabLayoutReminder, binding.viewPagerReminder) { tab, position ->
            when(position){
                0 -> tab.text = "Week"
                1 -> tab.text = "Month"
                2 -> tab.text = "Everyday"
            }
        }.attach()
    }

}