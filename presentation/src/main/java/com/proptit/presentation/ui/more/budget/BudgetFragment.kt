package com.proptit.presentation.ui.more.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.tabs.TabLayout
import com.proptit.domain.model.budget.BudgetType
import com.proptit.presentation.R
import com.proptit.presentation.databinding.FragmentBudgetBinding
import com.proptit.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

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
        budgetViewModel.budgetsWithCategoryByType.onEach { budgetsWithCategoryByType ->
            budgetAdapter.setBudgetsWithCategory(budgetsWithCategoryByType)
        }.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun changeTab(position: Int) {
        when (position) {
            0 -> {
                budgetViewModel.getBudgetsWithCategoryByType(BudgetType.WEEKLY)
            }

            1 -> {
                budgetViewModel.getBudgetsWithCategoryByType(BudgetType.MONTHLY)
            }

            2 -> {
                budgetViewModel.getBudgetsWithCategoryByType(BudgetType.ANNUALLY)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}