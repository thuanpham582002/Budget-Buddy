package com.proptit.budgetbuddy.presentation.ui.more.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.tabs.TabLayout
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentCategoryBinding
import com.proptit.budgetbuddy.domain.model.CategoryType
import com.proptit.budgetbuddy.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private val categoryViewModel: CategoryViewModel by viewModels()
    private var currentTabPosition = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TAG33", "onCreateView: ")
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
        initRecyclerViewCategories()
        initBehavior()
    }

    private fun initBehavior() {
        binding.buttonAdd.setOnClickListener {
            val bundle = bundleOf(Constant.CATEGORY_TYPE to binding.tabLayout.selectedTabPosition)
            findNavController().navigate(
                R.id.action_categoryFragment_to_addNewCategoryFragment,
                bundle
            )
        }
    }

    private fun initTabLayout() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Int>("currentTabPosition")
            ?.observe(viewLifecycleOwner) {
                binding.tabLayout.getTabAt(it)?.select()
                currentTabPosition = it
            }
        binding.tabLayout.apply {
            this.selectTab(this.getTabAt(currentTabPosition))
            changeTab(currentTabPosition)

            Log.d("TAG33", "selected: ${currentTabPosition}")
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    currentTabPosition = tab?.position!!
                    changeTab(tab.position)
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {

                }

                override fun onTabReselected(p0: TabLayout.Tab?) {

                }
            })
        }
    }

    private fun changeTab(selectedTabPosition: Int) {
        when (selectedTabPosition) {
            0 -> {
                categoryViewModel.getAllCategoriesByType(CategoryType.EXPENSES)
            }

            1 -> {
                categoryViewModel.getAllCategoriesByType(CategoryType.INCOME)
            }
        }
    }

    private fun initRecyclerViewCategories() {
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val categoryAdapter = CategoryAdapter(
            onItemClick = {
                val bundle = bundleOf(Constant.CATEGORY_ID to it)
                findNavController().navigate(
                    R.id.action_categoryFragment_to_categoryDetailFragment,
                    bundle
                )
            }
        )

        binding.recyclerViewCategory.apply {
            addItemDecoration(dividerItemDecoration)
            adapter = categoryAdapter
        }


        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryViewModel.categories.collect {
                    categoryAdapter.setCategories(it)

                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}