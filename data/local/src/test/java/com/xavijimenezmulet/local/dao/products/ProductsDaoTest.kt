@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.local.dao.products

import androidx.room.Room
import com.xavijimenezmulet.local.db.MobileChallengeDatabase
import com.xavijimenezmulet.local.mockdata.LocalMockData
import com.xavijimenezmulet.testutils.TestRobolectric
import com.xavijimenezmulet.utils.extension.orZero
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import java.io.IOException

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsDaoTest : TestRobolectric() {
    private lateinit var database: MobileChallengeDatabase

    private lateinit var dao: ProductsDao

    override fun onCreate() {
        super.onCreate()
        runTest {
            database = Room
                .inMemoryDatabaseBuilder(context, MobileChallengeDatabase::class.java)
                .allowMainThreadQueries()
                .build()
            dao = database.productsDao()
        }
    }

    @Throws(IOException::class)
    override fun onDestroy() {
        super.onDestroy()
        database.close()
    }

    @Test
    fun getProductList_WithData() = runTest {
        val fakeProduct = LocalMockData.getProductsList()
        dao.insert(fakeProduct)
        val products = dao.getProductList()
        Assert.assertEquals(fakeProduct, products)
    }

    @Test
    fun getProductList_WithoutData() = runTest {
        val products = dao.getProductList()
        Assert.assertTrue(products.isEmpty())
    }

    @Test
    fun getProductList_WithData_ShouldReturnSorted() = runTest {
        val fakeProduct = LocalMockData.getProductsList()
        dao.insert(fakeProduct)
        Assert.assertEquals(fakeProduct, dao.getProductList())
    }

    @Test
    fun getProductById_WithoutData_ShouldNotFound() = runTest {
        val fakeProducts = LocalMockData.getProductsList()
        val productToFind = fakeProducts.first()
        Assert.assertNull(dao.getProduct(productToFind.id.orZero()))
    }

    @Test
    fun getProductById_WithData_ShouldFound() = runTest {
        val fakeProducts = LocalMockData.getProductsList()
        dao.insert(fakeProducts)
        val productToFind = fakeProducts.first()
        Assert.assertEquals(productToFind, dao.getProduct(productToFind.id.orZero()))
    }
}