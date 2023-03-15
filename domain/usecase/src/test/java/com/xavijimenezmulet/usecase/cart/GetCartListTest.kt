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
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class GetCartListTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var repository: CartRepository

    @SpyK
    @InjectMockKs
    private lateinit var getCartList: GetCartList

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val unit = Unit

        // Act (When)
        getCartList.invoke(unit)

        // Assert (Then)
        coVerify { getCartList.invoke(Unit) }
    }
}