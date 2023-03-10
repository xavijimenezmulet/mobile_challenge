package com.xavijimenezmulet.mobilechallenge.di

import android.content.Context
import com.developersancho.framework.pref.CacheManager
import com.xavijimenezmulet.mobilechallenge.application.MobileChallengeApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(): MobileChallengeApplication {
        return MobileChallengeApplication()
    }

    @Provides
    @Singleton
    fun provideCacheManager(@ApplicationContext context: Context): CacheManager {
        return CacheManager(context)
    }
}