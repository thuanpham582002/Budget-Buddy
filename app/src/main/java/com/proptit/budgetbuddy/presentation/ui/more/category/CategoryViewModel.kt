package com.proptit.budgetbuddy.presentation.ui.more.category

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.budgetbuddy.domain.model.Category
import com.proptit.budgetbuddy.domain.model.CategoryType
import com.proptit.budgetbuddy.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryRepository: CategoryRepository) :
    ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()
    fun getAllCategoriesByType(categoryType: CategoryType) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.getAllCategoriesByType(categoryType).collect { categories ->
                Log.d("CategoryViewModel", "getAllCategoriesByType: ${categories}")
                _categories.update { categories }
            }
        }
    }

}