package com.proptit.data.di

import com.proptit.data.repository.AuthRepositoryImpl
import com.proptit.data.repository.BudgetRepositoryImpl
import com.proptit.data.repository.CategoryRepositoryImpl
import com.proptit.data.repository.ReminderRepositoryImpl
import com.proptit.data.repository.UserRepositoryImpl
import com.proptit.data.source.local.roomdb.dao.BudgetDao
import com.proptit.data.source.local.roomdb.dao.CategoryDao
import com.proptit.data.source.local.roomdb.dao.ReminderDao
import com.proptit.data.source.local.roomdb.dao.UserDao
import com.proptit.data.source.local.sharedpref.BudgetBuddySharedPref
import com.proptit.domain.repository.AuthRepository
import com.proptit.domain.repository.BudgetRepository
import com.proptit.domain.repository.CategoryRepository
import com.proptit.domain.repository.ReminderRepository
import com.proptit.domain.repository.UserRepository
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

    @Provides
    @Singleton
    fun provideReminderRepository(reminderDao: ReminderDao): ReminderRepository {
        return ReminderRepositoryImpl(reminderDao)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryDao: CategoryDao): CategoryRepository {
        return CategoryRepositoryImpl(categoryDao)
    }

    @Provides
    @Singleton
    fun provideBudgetRepository(budgetDao: BudgetDao): BudgetRepository {
        return BudgetRepositoryImpl(budgetDao)
    }
}