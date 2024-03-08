package com.proptit.budgetbuddy.di

import com.proptit.budgetbuddy.data.repository.AuthRepositoryImpl
import com.proptit.budgetbuddy.data.repository.UserRepositoryImpl
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.UserDao
import com.proptit.budgetbuddy.data.source.local.sharedpref.BudgetBuddySharedPref
import com.proptit.budgetbuddy.domain.repository.AuthRepository
import com.proptit.budgetbuddy.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(sharedPref: BudgetBuddySharedPref): AuthRepository {
        return AuthRepositoryImpl(sharedPref)
    }
}