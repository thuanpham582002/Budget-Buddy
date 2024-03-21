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
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentEditCategoryBinding
import com.proptit.budgetbuddy.presentation.ui.more.category.CategoryIconAdapter
import com.proptit.budgetbuddy.presentation.util.Constant
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
        }
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                categoryIconAdapter.setCategoryIcons(Constant.getCategoryIconLists())
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

    private fun receiveCategory() {
        val categoryId = arguments?.getInt(Constant.CATEGORY_ID)!!
        editCategoryViewModel.setCategory(categoryId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}