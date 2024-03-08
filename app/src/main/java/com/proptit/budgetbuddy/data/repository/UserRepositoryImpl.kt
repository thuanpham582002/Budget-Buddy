package com.proptit.budgetbuddy.data.repository

import com.proptit.budgetbuddy.data.source.local.roomdb.dao.UserDao
import com.proptit.budgetbuddy.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
}