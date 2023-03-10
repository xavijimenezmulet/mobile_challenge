package com.xavijimenezmulet.mobilechallenge.di

import com.xavijimenezmulet.mobilechallenge.application.MobileChallengeApplication
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
    fun provideApplication(): MobileChallengeApplication {
        return MobileChallengeApplication()
    }
}