package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.source.local.sharedpref.BudgetBuddySharedPref
import com.proptit.budgetbuddy.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPref: BudgetBuddySharedPref
) : AuthRepository {
    override fun isSignedIn(): Boolean {
        return getSignedInUserId() != -1
    }

    override fun signIn(userId: Int) {
        sharedPref.put("user_id", 1)
    }

    override fun getSignedInUserId(): Int {
        return sharedPref.get("user_id", -1)
    }

    override fun signOut() {
        sharedPref.put("user_id", -1)
    }
}