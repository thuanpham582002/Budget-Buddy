package com.proptit.budgetbuddy.presentation.ui.more.category.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.data.source.local.sharedpref.BudgetBuddySharedPref
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val sharePref: BudgetBuddySharedPref
) : ViewModel() {

    private val _category = MutableStateFlow<Category?>(null)
    val category = _category.asStateFlow()

    fun setCategory(categoryId: Int) {
        val userId = sharePref.get("user_id", -1)
        if (userId != -1) {
            viewModelScope.launch(Dispatchers.IO) {
                categoryRepository.getCategoryByUserIdAndCategoryId(userId, categoryId).let {
                    _category.value = it
                }
            }
        }
    }


}