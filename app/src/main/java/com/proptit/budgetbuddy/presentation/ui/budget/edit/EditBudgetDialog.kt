package com.proptit.budgetbuddy.presentation.ui.budget.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.proptit.budgetbuddy.databinding.DialogUpdateBudgetBinding
import com.proptit.budgetbuddy.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditBudgetDialog : DialogFragment() {
    private var _binding: DialogUpdateBudgetBinding? = null
    private val binding get() = _binding!!
    private val editBudgetViewModel: EditBudgetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogUpdateBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receiveBudget()
        initBehavior()
    }

    private fun receiveBudget() {
        editBudgetViewModel.setBudget(arguments?.getInt(Constant.BUDGET_ID)!!)
        viewLifecycleOwner.lifecycleScope.launch {
            editBudgetViewModel.budget.collect {
                binding.editTextAmount.setText(it?.amount?.toString() ?: "")
            }
        }
    }

    private fun initBehavior() {
        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
        binding.buttonOk.setOnClickListener {
            saveBudget()
        }
    }

    private fun saveBudget() {
        editBudgetViewModel.saveBudget(binding.editTextAmount.text.toString().toInt())
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}