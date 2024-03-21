package com.proptit.budgetbuddy.presentation.ui.more.category.add

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentAddNewCategoryBinding
import com.proptit.budgetbuddy.domain.model.CategoryType
import com.proptit.budgetbuddy.presentation.ui.more.category.CategoryIconAdapter
import com.proptit.budgetbuddy.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddNewCategoryFragment : Fragment() {

    private var _binding: FragmentAddNewCategoryBinding? = null
    private val binding get() = _binding!!


    private val addNewCategoryViewModel: AddNewCategoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewCategoryIcons()
        initBehavior()
    }

    private fun initBehavior() {
        binding.editTextCategoryName.setOnClickListener {

        }

        binding.imageViewBack.setOnClickListener {
            val type = arguments?.getInt(Constant.CATEGORY_TYPE)!!
            findNavController().previousBackStackEntry?.savedStateHandle?.set(Constant.CURRENT_TAB_POSITION, type)
            findNavController().popBackStack()
        }

        binding.imageViewDone.setOnClickListener {
            val categoryName = binding.textInputEditText.text.toString()
            if (categoryName.isEmpty()) {
                binding.editTextCategoryName.error = getString(R.string.please_enter_category_name)
            } else {
                val type = arguments?.getInt(Constant.CATEGORY_TYPE)!!
                val categoryType = when (type) {
                    0 -> CategoryType.EXPENSES
                    else -> CategoryType.INCOME
                }
                addNewCategoryViewModel.addNewCategory(
                    categoryName,
                    addNewCategoryViewModel.iconUrl.value,
                    categoryType
                )
                binding.editTextCategoryName.error = null
                findNavController().previousBackStackEntry?.savedStateHandle?.set(Constant.CURRENT_TAB_POSITION, type)
                findNavController().popBackStack()
            }
        }
    }

    private fun initRecyclerViewCategoryIcons() {
        val categoryIconAdapter = CategoryIconAdapter(
            onItemClick = { it ->
                addNewCategoryViewModel.updateIconUrl(it)
            }
        )
        binding.recyclerViewCategoryIcon.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = categoryIconAdapter
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryIconAdapter.setCategoryIcons(Constant.getCategoryIconLists())
            }
        }
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                addNewCategoryViewModel.iconUrl.collect {
                    Glide.with(requireContext()).load(Uri.parse(it))
                        .into(binding.imageViewNewCategory)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}