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
import com.proptit.budgetbuddy.domain.model.IconSection
import com.proptit.budgetbuddy.domain.model.IconSectionHeader
import com.proptit.budgetbuddy.domain.model.IconSectionItem
import com.proptit.budgetbuddy.presentation.ui.more.category.CategoryIconAdapter
import com.proptit.budgetbuddy.presentation.util.Constant
import com.shuhart.stickyheader.StickyHeaderItemDecorator
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
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                Constant.CURRENT_TAB_POSITION,
                type
            )
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
                findNavController().previousBackStackEntry?.savedStateHandle?.set(
                    Constant.CURRENT_TAB_POSITION,
                    type
                )
                findNavController().popBackStack()
            }
        }
    }

    private fun initRecyclerViewCategoryIcons() {
//        val categoryIconAdapter = CategoryIconAdapter(
//            onItemClick = { it ->
//                addNewCategoryViewModel.updateIconUrl(it)
//            }
//        )
//        binding.recyclerViewCategoryIcon.apply {
//            layoutManager = GridLayoutManager(requireContext(), 4)
//            adapter = categoryIconAdapter
//        }
//
//        lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                categoryIconAdapter.setCategoryIcons(Constant.getCategoryIconLists())
//            }
//        }
        val categoryIconAdapter = CategoryIconAdapter(
            onItemClick = { it ->
                addNewCategoryViewModel.updateIconUrl(it)
            }
        )
        binding.recyclerViewCategoryIcon.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = categoryIconAdapter
            layoutManager.apply {
                (this as GridLayoutManager).spanSizeLookup =
                    object : GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(position: Int): Int {
                            return when (position) {
                                0, 36, 48, 59, 62, 67, 77, 93, 109, 114, 122, 129, 140, 150, 158, 168, 176, 197, 207, 211, 219, 224, 236 -> 4
                                else -> 1
                            }
                        }

                    }
            }
        }
        lifecycleScope.launch {
            val categoryIconAdapter = CategoryIconAdapter(
                onItemClick = { it ->
                    addNewCategoryViewModel.updateIconUrl(it)
                }
            )

            binding.recyclerViewCategoryIcon.apply {
                layoutManager = GridLayoutManager(requireContext(), 4)
                adapter = categoryIconAdapter
                layoutManager.apply {
                    (this as GridLayoutManager).spanSizeLookup =
                        object : GridLayoutManager.SpanSizeLookup() {
                            override fun getSpanSize(position: Int): Int {
                                return when (categoryIconAdapter.getItemViewType(position)) {
                                    IconSection.HEADER -> 4
                                    else -> 1
                                }
                            }

                        }
                }
            }

            val decorator = StickyHeaderItemDecorator(categoryIconAdapter)
            decorator.attachToRecyclerView(binding.recyclerViewCategoryIcon)

            lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    val categoryIcons = Constant.getCategoryIconLists()
                    val iconSectionList = mutableListOf<IconSection>()
                    for (i in categoryIcons.indices) {
                        if (i < 36) {
                            addNewSections(categoryIcons, iconSectionList, i, 0)
                        } else if (i < 48) {
                            addNewSections(categoryIcons, iconSectionList, i, 36)
                        } else if (i < 59) {
                            addNewSections(categoryIcons, iconSectionList, i, 48)
                        } else if (i < 62) {
                            addNewSections(categoryIcons, iconSectionList, i, 59)
                        } else if (i < 67) {
                            addNewSections(categoryIcons, iconSectionList, i, 62)
                        } else if (i < 77) {
                            addNewSections(categoryIcons, iconSectionList, i, 67)
                        } else if (i < 93) {
                            addNewSections(categoryIcons, iconSectionList, i, 77)
                        } else if (i < 109) {
                            addNewSections(categoryIcons, iconSectionList, i, 93)
                        } else if (i < 114) {
                            addNewSections(categoryIcons, iconSectionList, i, 109)
                        } else if (i < 122) {
                            addNewSections(categoryIcons, iconSectionList, i, 114)
                        } else if (i < 129) {
                            addNewSections(categoryIcons, iconSectionList, i, 122)
                        } else if (i < 140) {
                            addNewSections(categoryIcons, iconSectionList, i, 129)
                        } else if (i < 150) {
                            addNewSections(categoryIcons, iconSectionList, i, 140)
                        } else if (i < 158) {
                            addNewSections(categoryIcons, iconSectionList, i, 150)
                        } else if (i < 168) {
                            addNewSections(categoryIcons, iconSectionList, i, 158)
                        } else if (i < 176) {
                            addNewSections(categoryIcons, iconSectionList, i, 168)
                        } else if (i < 197) {
                            addNewSections(categoryIcons, iconSectionList, i, 176)
                        } else if (i < 207) {
                            addNewSections(categoryIcons, iconSectionList, i, 197)
                        } else if (i < 211) {
                            addNewSections(categoryIcons, iconSectionList, i, 207)
                        } else if (i < 219) {
                            addNewSections(categoryIcons, iconSectionList, i, 211)
                        } else if (i < 224) {
                            addNewSections(categoryIcons, iconSectionList, i, 219)
                        } else if (i < 236) {
                            addNewSections(categoryIcons, iconSectionList, i, 224)
                        } else if (i < 246) {
                            addNewSections(categoryIcons, iconSectionList, i, 236)
                        }
                    }
                    categoryIconAdapter.setCategoryIcons(iconSectionList)
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
    }

    private fun addNewSections(
        categoryIcons: List<String>,
        iconSectionList: MutableList<IconSection>,
        i: Int,
        section: Int
    ) {
        if (i == section) {
            iconSectionList.add(IconSectionHeader(section, categoryIcons[i]))
        } else {
            iconSectionList.add(IconSectionItem(section, categoryIcons[i]))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}