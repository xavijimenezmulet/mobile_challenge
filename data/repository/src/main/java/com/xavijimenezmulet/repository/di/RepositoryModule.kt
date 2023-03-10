package com.xavijimenezmulet.repository.di

import android.annotation.SuppressLint
import android.content.Context
import com.xavijimenezmulet.repository.welcome.WelcomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWelcomeRepository(
        @ApplicationContext context: Context
    ) = WelcomeRepository(context)
}