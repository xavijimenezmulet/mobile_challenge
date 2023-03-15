package com.xavijimenezmulet.local.db

import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.local.dao.products.ProductsDao
import com.xavijimenezmulet.testutils.TestRobolectric
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class MobileChallengeDatabaseTest : TestRobolectric() {

    @MockK
    lateinit var database: MobileChallengeDatabase

    @MockK
    lateinit var productsDao: ProductsDao

    @MockK
    lateinit var cartDao: CartDao

    @Test
    fun database_productsDao_checkEveryDao() {
        every { database.productsDao() } returns productsDao

        MatcherAssert.assertThat(
            database.productsDao(),
            CoreMatchers.instanceOf(ProductsDao::class.java)
        )
    }

    @Test
    fun database_cartDao_checkEveryDao() {
        every { database.cartDao() } returns cartDao

        MatcherAssert.assertThat(
            database.cartDao(),
            CoreMatchers.instanceOf(CartDao::class.java)
        )
    }
}