package com.xavijimenezmulet.usecase.di

import android.annotation.SuppressLint
import com.xavijimenezmulet.repository.welcome.WelcomeRepository
import com.xavijimenezmulet.usecase.welcome.ReadOnBoarding
import com.xavijimenezmulet.usecase.welcome.SaveOnBoarding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class WelcomeModule {

    @Singleton
    @Provides
    fun provideSaveOnBoarding(repository: WelcomeRepository): SaveOnBoarding {
        return SaveOnBoarding(repository)
    }

    @Singleton
    @Provides
    fun provideReadOnBoarding(repository: WelcomeRepository): ReadOnBoarding {
        return ReadOnBoarding(repository)
    }
}