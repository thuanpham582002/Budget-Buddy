package com.proptit.budgetbuddy.di

import android.app.Application
import androidx.room.Room
import com.proptit.budgetbuddy.data.source.local.roomdb.BudgetBuddyDatabase
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.CategoryDao
import com.proptit.budgetbuddy.data.source.local.roomdb.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): BudgetBuddyDatabase {
        return Room.databaseBuilder(
            application,
            BudgetBuddyDatabase::class.java,
            BudgetBuddyDatabase.DATABASE_NAME
        ).addCallback(BudgetBuddyDatabase.callback).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: BudgetBuddyDatabase): UserDao {
        return database.userDao
    }

    @Provides
    @Singleton
    fun provideCategoryDao(database: BudgetBuddyDatabase): CategoryDao {
        return database.categoryDao
    }
}