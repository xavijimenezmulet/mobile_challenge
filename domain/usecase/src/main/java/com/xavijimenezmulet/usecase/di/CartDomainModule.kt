package com.xavijimenezmulet.usecase.di

import android.annotation.SuppressLint
import com.xavijimenezmulet.repository.cart.CartRepository
import com.xavijimenezmulet.usecase.cart.AddToCartProduct
import com.xavijimenezmulet.usecase.cart.GetCartList
import com.xavijimenezmulet.usecase.cart.GetCartProduct
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class CartDomainModule {
    @Singleton
    @Provides
    fun provideGetCartList(repository: CartRepository): GetCartList {
        return GetCartList(repository)
    }

    @Singleton
    @Provides
    fun provideGetCartProduct(repository: CartRepository): GetCartProduct {
        return GetCartProduct(repository)
    }

    @Singleton
    @Provides
    fun provideAddToCartProduct(repository: CartRepository): AddToCartProduct {
        return AddToCartProduct(repository)
    }
}