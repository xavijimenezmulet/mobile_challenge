package com.xavijimenezmulet.usecase.di

import android.annotation.SuppressLint
import com.xavijimenezmulet.repository.products.ProductsRepository
import com.xavijimenezmulet.usecase.products.GetProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class ProductsDomainModule {

    @Singleton
    @Provides
    fun provideGetCharacters(repository: ProductsRepository): GetProducts {
        return GetProducts(repository)
    }
}