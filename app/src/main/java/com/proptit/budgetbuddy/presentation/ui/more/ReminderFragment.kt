package com.proptit.budgetbuddy.presentation.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.slider.Slider
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentReminderBinding
import com.proptit.budgetbuddy.presentation.util.TimeStateMapper

class ReminderFragment : Fragment() {
    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!
    private var type: Boolean = false
    private lateinit var slider: Slider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehaviour()
    }

    private fun initBehaviour() {
        slider = binding.sliderTime
        binding.textViewHour.setTextColor(resources.getColor(R.color.pink_1, null))
        onClickListener()
        initAnimation()
    }

    private fun onClickListener() {
        binding.textViewMinute.setOnClickListener {
            type = true
            toggleSliderChange()
            binding.textViewHour.setTextColor(resources.getColor(R.color.gray, null))
            binding.textViewMinute.setTextColor(resources.getColor(R.color.pink_1, null))
        }

        binding.textViewHour.setOnClickListener {
                type = false
                toggleSliderChange()
                binding.textViewMinute.setTextColor(resources.getColor(R.color.gray, null))
                binding.textViewHour.setTextColor(resources.getColor(R.color.pink_1, null))
            }

    }

    private fun toggleSliderChange() {
        if (type) {
            slider.valueTo = 59f
            slider.stepSize = 0f
            slider.value = binding.textViewMinute.text.toString().toFloat()
        } else {
            slider.valueTo = 92f
            slider.stepSize = 4f
            slider.value = binding.textViewHour.text.toString().toFloat() * 4
        }
    }


    private fun initAnimation() {
        val motionLayout = binding.motionLayoutReminder
        slider.addOnChangeListener { _, _, _ ->
            if (!type) {
                val time = (slider.value / 4).toInt()
                val nextState = TimeStateMapper.getState(time)
                motionLayout.transitionToState(nextState)
                binding.textViewHour.text = String.format("%02d", time)
            } else {
                binding.textViewMinute.text = String.format("%02d", slider.value.toInt())
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}