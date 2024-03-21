package com.proptit.budgetbuddy.presentation.ui.more.category.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.data.source.local.sharedpref.BudgetBuddySharedPref
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditCategoryViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val sharePref: BudgetBuddySharedPref
) : ViewModel() {

    private val _category = MutableStateFlow<Category?>(null)
    val category = _category.asStateFlow()

    private val _iconUrl = MutableStateFlow<String>("")
    val iconUrl = _iconUrl.asStateFlow()
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

    fun updateIconUrl(url: String) {
        _iconUrl.update { url }
    }

    fun updateCategory(name: String, iconUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val category = _category.value!!
            categoryRepository.updateCategory(
                Category(
                    id = category.id,
                    userId = category.userId,
                    name = name,
                    iconUrl = iconUrl,
                    type = category.type
                )
            )
        }
    }

    fun deleteCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            val category = _category.value!!
            categoryRepository.deleteCategory(
                Category(
                    id = category.id,
                    userId = category.userId,
                    name = category.name,
                    iconUrl = category.iconUrl,
                    type = category.type
                )
            )
        }
    }
}