package com.proptit.presentation.ui.more.reminder.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.proptit.presentation.databinding.FragmentReminderBinding
import com.proptit.presentation.util.TimeStateMapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.proptit.common.R as commonR
import com.proptit.presentation.R as presentationR

@AndroidEntryPoint
class AddReminderFragment : Fragment() {
    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!
    private var sliderType: Boolean = false
    private var isUpdate: Boolean = false
    private val addReminderViewModel: AddReminderViewModel by viewModels()

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
        receiveReminder()
        initComponents()
        onClickListener()
        initAnimation()
    }

    private fun initComponents() {
        binding.textViewHour.setTextColor(resources.getColor(commonR.color.pink_1, null))
    }

    private fun onClickListener() {
        binding.textViewMinute.setOnClickListener {
            sliderType = true
            toggleSliderChange()
            binding.textViewHour.setTextColor(resources.getColor(commonR.color.gray, null))
            binding.textViewMinute.setTextColor(resources.getColor(commonR.color.pink_1, null))
        }

        binding.textViewHour.setOnClickListener {
            sliderType = false
            toggleSliderChange()
            binding.textViewMinute.setTextColor(resources.getColor(commonR.color.gray, null))
            binding.textViewHour.setTextColor(resources.getColor(commonR.color.pink_1, null))
        }

        binding.appBarReminder.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.appBarReminder.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                presentationR.id.done -> {
                    if (isUpdate) {
                        addReminderViewModel.updateReminder(
                            binding.textViewHour.text.toString().toInt(),
                            binding.textViewMinute.text.toString().toInt(),
                            "check content",
                            true,
                        )
                    } else {
                        addReminderViewModel.addReminder(
                            binding.textViewHour.text.toString().toInt(),
                            binding.textViewMinute.text.toString().toInt(),
                            "check content",
                            isActive = true
                        )
                    }
                    findNavController().popBackStack()
                    true
                }

                else -> false
            }
        }
        binding.constraintLayoutCycle.setOnClickListener {
            findNavController().navigate(presentationR.id.action_reminderFragment_to_reminderDialogFragment)
        }
    }

    private fun toggleSliderChange() {
        if (sliderType) {
            binding.sliderTime.valueTo = 59f
            binding.sliderTime.stepSize = 0f
            binding.sliderTime.value = binding.textViewMinute.text.toString().toFloat()
        } else {
            binding.sliderTime.valueTo = 92f
            binding.sliderTime.stepSize = 4f
            binding.sliderTime.value = binding.textViewHour.text.toString().toFloat() * 4
        }
    }


    private fun initAnimation() {
        val motionLayout = binding.motionLayoutReminder
        binding.sliderTime.addOnChangeListener { _, _, _ ->
            if (!sliderType) {
                val time = (binding.sliderTime.value / 4).toInt()
                val nextState = TimeStateMapper.getState(time)
                motionLayout.transitionToState(nextState)
                binding.textViewHour.text = String.format("%02d", time)
            } else {
                binding.textViewMinute.text =
                    String.format("%02d", binding.sliderTime.value.toInt())
            }
        }

    }

    private fun receiveReminder() {
        val id = arguments?.getInt("reminderId")
        if (id != null) {
            addReminderViewModel.setReminder(id)
            viewLifecycleOwner.lifecycleScope.launch {
                addReminderViewModel.reminder.collect {
                    if (it != null) {
                        isUpdate = true
                        binding.textViewHour.text = String.format("%02d", it.getHour())
                        binding.textViewMinute.text = String.format("%02d", it.getMinute())
                        binding.sliderTime.value = it.getHour().toFloat() * 4
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}