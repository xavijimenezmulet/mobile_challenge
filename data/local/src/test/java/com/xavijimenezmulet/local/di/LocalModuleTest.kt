package com.xavijimenezmulet.local.di

import android.content.Context
import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.local.dao.products.ProductsDao
import com.xavijimenezmulet.local.db.MobileChallengeDatabase
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class LocalModuleTest : MockkUnitTest() {

    private lateinit var localModule: LocalModule

    override fun onCreate() {
        super.onCreate()
        localModule = LocalModule()
    }

    @Test
    fun verifyProvideDatabaseName() {
        val databaseName = localModule.provideDatabaseName()
        assertEquals(databaseName, "db_name")
    }

    @Test
    fun verifyProvideDatabase() {
        val context: Context = mockk()
        val databaseName = localModule.provideDatabaseName()
        val database = localModule.provideDatabase(databaseName, context)

        assertNotNull(database.productsDao())
        assertNotNull(database.cartDao())
    }

    @Test
    fun verifyProvideProductsDao() {
        val database: MobileChallengeDatabase = mockk()
        val dao: ProductsDao = mockk()

        every { database.productsDao() } returns dao

        assertEquals(
            dao,
            localModule.provideProductsDao(database)
        )
        verify { database.productsDao() }
    }

    @Test
    fun verifyProvideCartDao() {
        val database: MobileChallengeDatabase = mockk()
        val dao: CartDao = mockk()

        every { database.cartDao() } returns dao

        assertEquals(
            dao,
            localModule.provideCartDao(database)
        )
        verify { database.cartDao() }
    }
}