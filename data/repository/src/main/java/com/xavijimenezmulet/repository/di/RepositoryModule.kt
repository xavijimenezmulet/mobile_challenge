package com.xavijimenezmulet.repository.di

import android.annotation.SuppressLint
import android.content.Context
import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.local.dao.products.ProductsDao
import com.xavijimenezmulet.remote.service.products.ProductsService
import com.xavijimenezmulet.repository.cart.CartRepository
import com.xavijimenezmulet.repository.products.ProductsRepository
import com.xavijimenezmulet.repository.welcome.WelcomeRepository
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
@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWelcomeRepository(
        @ApplicationContext context: Context
    ) = WelcomeRepository(context)

    @Singleton
    @Provides
    fun provideProductsRepository(
        service: ProductsService,
        dao: ProductsDao
    ) = ProductsRepository(service, dao)

    @Singleton
    @Provides
    fun provideCartRepository(
        dao: CartDao
    ) = CartRepository(dao)
}