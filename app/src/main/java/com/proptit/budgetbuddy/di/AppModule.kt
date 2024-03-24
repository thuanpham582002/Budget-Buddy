package com.proptit.budgetbuddy.di

import android.app.Application
import com.proptit.data.source.local.sharedpref.BudgetBuddySharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideBudgetBuddySharedPref(application: Application): BudgetBuddySharedPref {
        return BudgetBuddySharedPref(application)
    }
}