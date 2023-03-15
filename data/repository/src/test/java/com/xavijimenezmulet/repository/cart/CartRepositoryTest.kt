@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.repository.cart

import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.model.local.cart.CartItemClickEntity
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class CartRepositoryTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var dao: CartDao

    private lateinit var repository: CartRepository

    override fun onCreate() {
        super.onCreate()
        repository = CartRepository(dao)
    }

    @Test
    fun getCartList() = runTest {
        repository.getCartItemList()

        coVerify { dao.getCartItemList() }
    }

    @Test
    fun getCartItem() = runTest {
        val cartIdToFind = "VOUCHER"
        val cartIdCaptor = slot<String>()

        repository.getCartItem(cartIdToFind)

        coVerify { dao.getCartItem(capture(cartIdCaptor)) }

        assertEquals(cartIdToFind, cartIdCaptor.captured)
    }

    @Test
    fun saveItem() = runTest {
        val itemToInsert = Cart(
            code = "VOUCHER",
            name = "Cabify Voucher",
            price = 5f,
            promo = "NONE",
            count = 5
        )

        val characterCaptor = slot<CartItemClickEntity>()
        repository.saveCartItem(itemToInsert)

        coVerify { dao.insert(capture(characterCaptor)) }
        assertEquals(itemToInsert.code, characterCaptor.captured.code)
    }

    @Test
    fun deleteCartById() = runTest {
        val characterIdToDelete = "VOUCHER"
        val characterIdCaptor = slot<String>()
        repository.deleteCartItem(characterIdToDelete)

        coVerify {
            dao.deleteItem(capture(characterIdCaptor))
        }
        assertEquals(characterIdToDelete, characterIdCaptor.captured)
    }
}