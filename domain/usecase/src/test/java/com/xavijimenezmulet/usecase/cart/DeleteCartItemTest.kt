@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.usecase.cart

import com.xavijimenezmulet.entity.cart.Cart
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
class DeleteCartItemTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var repository: CartRepository

    @SpyK
    @InjectMockKs
    private lateinit var deleteCartItem: DeleteCartItem

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val cart = mockk<Cart>()

        // Act (When)
        deleteCartItem.invoke(DeleteCartItem.Params(cart))

        // Assert (Then)
        coVerify { deleteCartItem.invoke(any()) }
    }
}