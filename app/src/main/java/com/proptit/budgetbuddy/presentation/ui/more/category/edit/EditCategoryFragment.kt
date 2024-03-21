package com.proptit.budgetbuddy.presentation.ui.more.category.edit

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentEditCategoryBinding
import com.proptit.budgetbuddy.domain.model.IconSection
import com.proptit.budgetbuddy.domain.model.IconSectionHeader
import com.proptit.budgetbuddy.domain.model.IconSectionItem
import com.proptit.budgetbuddy.presentation.ui.more.category.CategoryIconAdapter
import com.proptit.budgetbuddy.presentation.util.Constant
import com.shuhart.stickyheader.StickyHeaderItemDecorator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditCategoryFragment : Fragment() {

    private var _binding: FragmentEditCategoryBinding? = null
    private val binding get() = _binding!!
    private val editCategoryViewModel: EditCategoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        initBehavior()
    }

    private fun initBehavior() {
        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.imageViewDone.setOnClickListener {
            val categoryName = binding.editTextCategoryName.text.toString()
            val iconUrl = editCategoryViewModel.iconUrl.value
            editCategoryViewModel.updateCategory(categoryName, iconUrl)
            findNavController().popBackStack()
        }

        binding.imageViewDelete.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext()).apply {
                setTitle(getString(R.string.delete_category))
                setMessage(getString(R.string.delete_category_alert))
                setPositiveButton(getString(R.string.ok)) { _, _ ->
                    editCategoryViewModel.deleteCategory()
                    findNavController().popBackStack()
                    findNavController().popBackStack()
                }
                setNegativeButton(getString(R.string.cancel)) { _, _ -> }
                show()
            }
        }
    }

    private fun initComponent() {
        receiveCategory()
        viewLifecycleOwner.lifecycleScope.launch {
            editCategoryViewModel.category.collect {
                binding.editTextCategoryName.setText(it?.name)
                Glide.with(requireContext()).load(Uri.parse(it?.iconUrl ?: ""))
                    .into(binding.imageViewEditCategory)
            }
        }
        initRecyclerViewCategoryIcons()
    }

    private fun initRecyclerViewCategoryIcons() {
        val categoryIconAdapter = CategoryIconAdapter(
            onItemClick = { it ->
                editCategoryViewModel.updateIconUrl(it)
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
                    if (i <36) {
                        addNewSections(categoryIcons, iconSectionList, i, 0)
                    } else if (i < 48){
                        addNewSections(categoryIcons, iconSectionList, i, 36)
                    } else if (i< 59){
                        addNewSections(categoryIcons, iconSectionList, i, 48)
                    } else if (i<62){
                        addNewSections(categoryIcons, iconSectionList, i, 59)
                    } else if (i< 67){
                        addNewSections(categoryIcons, iconSectionList, i, 62)
                    } else if (i < 77){
                        addNewSections(categoryIcons, iconSectionList, i, 67)
                    }else if (i < 93){
                        addNewSections(categoryIcons, iconSectionList, i, 77)
                    }else if (i < 109){
                        addNewSections(categoryIcons, iconSectionList, i, 93)
                    }else if (i < 114){
                        addNewSections(categoryIcons, iconSectionList, i, 109)
                    }else if (i < 122){
                        addNewSections(categoryIcons, iconSectionList, i, 114)
                    }else if (i < 129){
                        addNewSections(categoryIcons, iconSectionList, i, 122)
                    }else if (i < 140){
                        addNewSections(categoryIcons, iconSectionList, i, 129)
                    }else if (i < 150){
                        addNewSections(categoryIcons, iconSectionList, i, 140)
                    } else if (i < 158){
                        addNewSections(categoryIcons, iconSectionList, i, 150)
                    }else if (i < 168){
                        addNewSections(categoryIcons, iconSectionList, i, 158)
                    }else if (i < 176){
                        addNewSections(categoryIcons, iconSectionList, i, 168)
                    }else if (i < 197){
                        addNewSections(categoryIcons, iconSectionList, i, 176)
                    }else if (i < 207){
                        addNewSections(categoryIcons, iconSectionList, i, 197)
                    }else if (i < 211){
                        addNewSections(categoryIcons, iconSectionList, i, 207)
                    } else if (i < 219){
                        addNewSections(categoryIcons, iconSectionList, i, 211)
                    }else if (i < 224){
                        addNewSections(categoryIcons, iconSectionList, i, 219)
                    }else if (i < 236){
                        addNewSections(categoryIcons, iconSectionList, i, 224)
                    }else if (i < 246){
                        addNewSections(categoryIcons, iconSectionList, i, 236)
                    }
                }
                categoryIconAdapter.setCategoryIcons(iconSectionList)
            }
        }
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                editCategoryViewModel.iconUrl.collect {
                    Glide.with(requireContext()).load(Uri.parse(it))
                        .into(binding.imageViewEditCategory)
                }
            }
        }
    }

    private fun addNewSections(categoryIcons: List<String>, iconSectionList: MutableList<IconSection>, i: Int, section: Int) {
        if (i == section){
            iconSectionList.add(IconSectionHeader(section, categoryIcons[i]))
        } else{
            iconSectionList.add(IconSectionItem(section, categoryIcons[i]))
        }
    }

    private fun receiveCategory() {
        val categoryId = arguments?.getInt(Constant.CATEGORY_ID)!!
        editCategoryViewModel.setCategory(categoryId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}