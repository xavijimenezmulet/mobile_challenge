@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.local.dao.cart

import androidx.room.Room
import com.xavijimenezmulet.local.db.MobileChallengeDatabase
import com.xavijimenezmulet.local.mockdata.LocalMockData
import com.xavijimenezmulet.model.local.cart.CartItemClickEntity
import com.xavijimenezmulet.testutils.TestRobolectric
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Test
import java.io.IOException

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class CartDaoTest : TestRobolectric() {
    private lateinit var database: MobileChallengeDatabase

    private lateinit var dao: CartDao

    override fun onCreate() {
        super.onCreate()
        runTest {
            database = Room
                .inMemoryDatabaseBuilder(context, MobileChallengeDatabase::class.java)
                .allowMainThreadQueries()
                .build()
            dao = database.cartDao()
        }
    }

    @Throws(IOException::class)
    override fun onDestroy() {
        super.onDestroy()
        database.close()
    }

    @Test
    fun getCartList_WithData_NotSameObjects() = runTest {
        val fakeCart = LocalMockData.getCartList()
        dao.insert(fakeCart)
        val cartList = dao.getCartItemList()
        Assert.assertNotEquals(fakeCart, cartList)
    }

    @Test
    fun getCartList_WithoutData() = runTest {
        val cartList = dao.getCartItemList()
        Assert.assertTrue(cartList.isEmpty())
    }

    @Test
    fun getCartById_WithoutData_ShouldNotFound() = runTest {
        val fakeCart = LocalMockData.getCartList()
        val cartToFind = fakeCart.first()
        Assert.assertNull(dao.getCartItem(cartToFind.code))
    }

    @Test
    fun insertCart_ShouldAdd() = runTest {
        val fakeCart = CartItemClickEntity(
            name = "Voucher",
            code = "VOUCHER",
            price = 5f,
            promo = "PROMO",
            count = 20
        )
        dao.insert(fakeCart)

        Assert.assertEquals(fakeCart.code, dao.getCartItem("VOUCHER")?.code)
    }

    @Test
    fun insertCart_ShouldAdd_butNotSame() = runTest {
        val fakeCart = CartItemClickEntity(
            name = "Voucher",
            code = "VOUCHER",
            price = 5f,
            promo = "PROMO",
            count = 20
        )
        dao.insert(fakeCart)

        Assert.assertNotEquals(fakeCart.code, dao.getCartItem("TSHIRT")?.code)
    }

    @Test
    fun deleteCartList_ShouldRemoveAll() = runTest {
        val fakeCart = LocalMockData.getCartList()
        dao.insert(fakeCart)
        dao.deleteCartList()

        Assert.assertTrue(dao.getCartItemList().isEmpty())
    }

    @Test
    fun deleteCart_Stored_ShouldRemoveIt() = runTest {
        val fakeCart = LocalMockData.getCartList()
        dao.insert(fakeCart)

        val cartToRemove = fakeCart.first()
        dao.delete(cartToRemove)

        MatcherAssert.assertThat(
            dao.getCartItemList(),
            CoreMatchers.not(CoreMatchers.hasItem(cartToRemove))
        )
    }

    @Test
    fun deleteCart_NoStored_ShouldNotRemoveNothing() = runTest {
        val fakeCart = LocalMockData.getCartList()
        dao.insert(fakeCart)

        val favoriteToRemove = CartItemClickEntity(
            name = "Voucher",
            code = "MUG",
            price = 5f,
            promo = "PROMO",
            count = 20
        )
        dao.delete(favoriteToRemove)

        Assert.assertEquals(fakeCart.size, dao.getCartItemList().size)
    }

}