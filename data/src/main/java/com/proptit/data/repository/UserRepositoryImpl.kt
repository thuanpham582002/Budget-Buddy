package com.proptit.data.repository

import com.proptit.data.source.local.roomdb.dao.UserDao
import com.proptit.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
}