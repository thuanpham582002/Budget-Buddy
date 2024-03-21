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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentCategoryBinding
import com.proptit.budgetbuddy.domain.model.CategoryType
import com.proptit.budgetbuddy.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Collections

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
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
        initRecyclerViewCategories()
        initBehavior()
        handleSlideCategory()
    }

    private fun handleSlideCategory() {
        val helper = ItemTouchHelper(object: ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                return makeMovementFlags(
                    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                    ItemTouchHelper.ACTION_STATE_IDLE
                )
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val draggedItemIndex = viewHolder.adapterPosition
                val targetItemIndex = target.adapterPosition
                Collections.swap(categoryViewModel.categories.value, draggedItemIndex, targetItemIndex)
                recyclerView.adapter?.notifyItemMoved(draggedItemIndex, targetItemIndex)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                Todo
            }
        })

        helper.attachToRecyclerView(binding.recyclerViewCategory)
    }

    private fun initBehavior() {
        binding.buttonAdd.setOnClickListener {
            val bundle = bundleOf(Constant.CATEGORY_TYPE to binding.tabLayout.selectedTabPosition)
            findNavController().navigate(
                R.id.action_categoryFragment_to_addNewCategoryFragment,
                bundle
            )
        }

        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initTabLayout() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Int>(Constant.CURRENT_TAB_POSITION)
            ?.observe(viewLifecycleOwner) {
                binding.tabLayout.getTabAt(it)?.select()
                currentTabPosition = it
            }
        binding.tabLayout.apply {
            this.selectTab(this.getTabAt(currentTabPosition))
            changeTab(currentTabPosition)
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
        val categoryAdapter = CategoryAdapter(
            onItemClick = {
                val bundle = bundleOf(Constant.CATEGORY_ID to it)
                findNavController().navigate(
                    R.id.action_categoryFragment_to_categoryDetailFragment,
                    bundle
                )
            },
            onDeleteClick = { categoryId ->
                MaterialAlertDialogBuilder(requireContext()).apply {
                    setTitle(getString(R.string.delete_category))
                    setMessage(getString(R.string.delete_category_alert))
                    setPositiveButton(getString(R.string.ok)) { _, _ ->
                        categoryViewModel.deleteCategory(categoryId)
                    }
                    setNegativeButton(getString(R.string.cancel)) { _, _ -> }
                    show()
                }
            }
        )

        binding.recyclerViewCategory.apply {
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