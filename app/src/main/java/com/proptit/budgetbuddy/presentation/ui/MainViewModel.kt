package com.proptit.budgetbuddy.presentation.ui

import androidx.lifecycle.ViewModel
import com.proptit.budgetbuddy.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    fun isSignedIn(): Boolean {
        return authRepository.isSignedIn()
    }

    fun signIn(userId: Int) {
        authRepository.signIn(userId)
    }

    fun getSignedInUserId(): Int {
        return authRepository.getSignedInUserId()
    }
}