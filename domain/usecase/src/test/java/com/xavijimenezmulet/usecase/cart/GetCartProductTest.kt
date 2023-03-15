@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.usecase.cart

import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.repository.cart.CartRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class GetCartProductTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var charRepo: CartRepository

    @SpyK
    @InjectMockKs
    private lateinit var getCartProduct: GetCartProduct

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val detailId = mockk<Product>()

        // Act (When)
        val params = GetCartProduct.Params(detailId)
        getCartProduct.invoke(params)

        // Assert (Then)
        coVerify { getCartProduct.invoke(any()) }
    }
}