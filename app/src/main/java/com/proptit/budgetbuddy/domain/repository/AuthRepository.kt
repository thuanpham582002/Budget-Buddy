package com.proptit.budgetbuddy.domain.repository

interface AuthRepository {
    fun isSignedIn(): Boolean
    fun signIn(userId: Int)
    fun getSignedInUserId(): Int
    fun signOut()
}