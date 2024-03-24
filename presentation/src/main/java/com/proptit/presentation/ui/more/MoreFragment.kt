package com.proptit.presentation.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.proptit.presentation.R
import com.proptit.presentation.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehavior()
    }

    private fun initBehavior() {
        binding.cardViewCategories.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_categoryFragment)
        }
        binding.imageViewReminder.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_reminderListFragment)
        }
        binding.cardViewBudget.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_budgetFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}