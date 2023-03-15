package com.xavijimenezmulet.usecase.di

import com.xavijimenezmulet.repository.cart.CartRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class CartDomainModuleTest : MockkUnitTest() {

    private lateinit var module: CartDomainModule

    override fun onCreate() {
        super.onCreate()
        module = CartDomainModule()
    }

    @Test
    fun verifyProvideGetCartList() {
        val repository = mockk<CartRepository>()
        val getCharacterList = module.provideGetCartList(repository)

        assertEquals(repository, getCharacterList.repository)
    }

    @Test
    fun verifyProvideGetProductDetail() {
        val repository = mockk<CartRepository>()
        val getCharacterDetail = module.provideGetCartProduct(repository)

        assertEquals(repository, getCharacterDetail.cartRepository)
    }

    @Test
    fun verifyProvideAddToCart() {
        val repository = mockk<CartRepository>()
        val getCharacterDetail = module.provideAddToCartProduct(repository)

        assertEquals(repository, getCharacterDetail.cartRepository)
    }
}