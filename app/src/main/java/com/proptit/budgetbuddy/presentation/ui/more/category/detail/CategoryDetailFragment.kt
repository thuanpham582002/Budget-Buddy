package com.proptit.budgetbuddy.presentation.ui.more.category.detail

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.proptit.budgetbuddy.R
import com.proptit.budgetbuddy.databinding.FragmentCategoryDetailBinding
import com.proptit.budgetbuddy.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryDetailFragment : Fragment() {

    private var _binding: FragmentCategoryDetailBinding? = null
    private val binding get() = _binding!!

    private val categoryDetailViewModel: CategoryDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        initBehavior()
    }

    private fun initBehavior() {
        binding.imageViewClose.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.imageViewEdit.setOnClickListener {
            val bundle =
                bundleOf(Constant.CATEGORY_ID to categoryDetailViewModel.category.value?.id)
            findNavController().navigate(
                R.id.action_categoryDetailFragment_to_editCategoryFragment,
                bundle
            )

        }
    }

    private fun initComponent() {
        receiveCategory()
        viewLifecycleOwner.lifecycleScope.launch {
            categoryDetailViewModel.category.collect {
                binding.textViewCategoryName.text = it?.name
                Glide.with(requireContext()).load(Uri.parse(it?.iconUrl ?: ""))
                    .into(binding.imageViewCategory)
            }
        }
    }

    private fun receiveCategory() {
        val categoryId = arguments?.getInt(Constant.CATEGORY_ID)!!
        categoryDetailViewModel.setCategory(categoryId)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}