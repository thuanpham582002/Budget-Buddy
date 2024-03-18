package com.proptit.budgetbuddy.presentation.ui.more.reminder.addReminder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.proptit.budgetbuddy.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {
    private var _binding: FragmentWeekBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeekBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehaviour()
    }

    private fun initBehaviour() {
        onClickListener()
    }

    private fun onClickListener() {
        binding.buttonMonday.setOnClickListener {
            if (binding.buttonMonday.isChecked) {
                setFragmentResult("requestKey", bundleOf("monday" to true))
            } else setFragmentResult("requestKey", bundleOf("monday" to false))
        }

        binding.buttonTuesday.setOnClickListener {
            if (binding.buttonTuesday.isChecked) {
                setFragmentResult("requestKey", bundleOf("tuesday" to true))
            } else setFragmentResult("requestKey", bundleOf("tuesday" to false))
        }

        binding.buttonWednesday.setOnClickListener {
            if (binding.buttonWednesday.isChecked) {
                setFragmentResult("requestKey", bundleOf("wednesday" to true))
            } else setFragmentResult("requestKey", bundleOf("wednesday" to false))
        }

        binding.buttonThursday.setOnClickListener {
            if (binding.buttonThursday.isChecked) {
                setFragmentResult("requestKey", bundleOf("thursday" to true))
            } else setFragmentResult("requestKey", bundleOf("thursday" to false))
        }

        binding.buttonFriday.setOnClickListener {
            if (binding.buttonFriday.isChecked) {
                setFragmentResult("requestKey", bundleOf("friday" to true))
            } else setFragmentResult("requestKey", bundleOf("friday" to false))
        }

        binding.buttonSaturday.setOnClickListener {
            if (binding.buttonSaturday.isChecked) {
                setFragmentResult("requestKey", bundleOf("saturday" to true))
            } else setFragmentResult("requestKey", bundleOf("saturday" to false))
        }

        binding.buttonSunday.setOnClickListener {
            if (binding.buttonSunday.isChecked) {
                setFragmentResult("requestKey", bundleOf("sunday" to true))
            } else setFragmentResult("requestKey", bundleOf("sunday" to false))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}