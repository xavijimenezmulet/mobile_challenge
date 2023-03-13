package com.xavijimenezmulet.mobilechallenge.di

import android.content.Context
import com.xavijimenezmulet.framework.base.pref.CacheManager
import com.xavijimenezmulet.mobilechallenge.provider.AppLanguageProvider
import com.xavijimenezmulet.mobilechallenge.provider.AppResourceProvider
import com.xavijimenezmulet.mobilechallenge.provider.AppThemeProvider
import com.xavijimenezmulet.provider.LanguageProvider
import com.xavijimenezmulet.provider.ResourceProvider
import com.xavijimenezmulet.provider.ThemeProvider
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
class ProviderModule {

    @Provides
    @Singleton
    fun provideThemeProvider(@ApplicationContext context: Context): ThemeProvider {
        return AppThemeProvider(context)
    }

    @Provides
    @Singleton
    fun provideAppResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return AppResourceProvider(context)
    }

    @Provides
    @Singleton
    fun provideAppLanguageProvider(cacheManager: CacheManager): LanguageProvider {
        return AppLanguageProvider(cacheManager)
    }
}