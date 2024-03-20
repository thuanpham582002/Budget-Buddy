package com.proptit.budgetbuddy.presentation.ui.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.tabs.TabLayout
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentBudgetBinding
import com.proptit.budgetbuddy.domain.model.BudgetType
import com.proptit.budgetbuddy.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BudgetFragment : Fragment() {
    private var _binding: FragmentBudgetBinding? = null
    private val binding get() = _binding!!
    private val budgetViewModel: BudgetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
        initTabLayout()
        initRecyclerViewBudgets()
    }

    private fun initToolBar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initTabLayout() {
        binding.tabLayout.apply {
            changeTab(this.selectedTabPosition)
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.let {
                        changeTab(it.position)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    // TODO
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    // TODO
                }
            })
        }
    }

    private fun initRecyclerViewBudgets() {
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val budgetAdapter = BudgetAdapter(
            onItemClick = {
                val bundle = bundleOf(Constant.BUDGET_ID to it)
                findNavController().navigate(
                    R.id.action_budgetFragment_to_updateBudgetDialogFragment,
                    bundle
                )
            }
        )
        binding.recyclerViewBudgets.apply {
            addItemDecoration(dividerItemDecoration)
            adapter = budgetAdapter
        }
        viewLifecycleOwner.lifecycleScope.launch {
            budgetViewModel.budgetsByType.collect {
                budgetAdapter.setBudgets(it)
            }
        }
    }

    private fun changeTab(position: Int) {
        when (position) {
            0 -> {
                budgetViewModel.getBudgetsByType(BudgetType.WEEKLY)
            }

            1 -> {
                budgetViewModel.getBudgetsByType(BudgetType.MONTHLY)
            }

            2 -> {
                budgetViewModel.getBudgetsByType(BudgetType.ANNUALLY)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}