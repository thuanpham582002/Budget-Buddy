package com.proptit.presentation.ui.more.category.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptit.common.BuildConfig
import com.proptit.common.R
import com.proptit.domain.model.Category
import com.proptit.domain.model.CategoryType
import com.proptit.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewCategoryViewModel @Inject constructor(private val categoryRepository: CategoryRepository) :
    ViewModel() {

    private val _iconUrl =
        MutableStateFlow<String>("android.resource://${BuildConfig.LIBRARY_PACKAGE_NAME}/drawable/" + "${R.drawable.ic_food}")
    val iconUrl = _iconUrl.asStateFlow()

    fun addNewCategory(name: String, iconUrl: String, type: CategoryType) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.insertCategory(
                Category(
                    userId = 1,
                    name = name,
                    iconUrl = iconUrl,
                    type = type
                )
            )
        }

    }

    fun updateIconUrl(url: String) {
        _iconUrl.update { url }
    }

}