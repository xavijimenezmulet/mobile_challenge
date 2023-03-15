@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.repository.products

import com.xavijimenezmulet.local.dao.products.ProductsDao
import com.xavijimenezmulet.model.dto.products.toProductDto
import com.xavijimenezmulet.model.dto.products.toProductDtoList
import com.xavijimenezmulet.model.dto.products.toProductRemoteList
import com.xavijimenezmulet.model.local.products.ProductEntity
import com.xavijimenezmulet.model.remote.products.ProductResponse
import com.xavijimenezmulet.model.remote.products.ProductsResponse
import com.xavijimenezmulet.remote.service.products.ProductsService
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsRepositoryTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var characterService: ProductsService

    @MockK(relaxed = true)
    lateinit var dao: ProductsDao

    private lateinit var repository: ProductsRepository

    override fun onCreate() {
        super.onCreate()
        repository = ProductsRepository(characterService, dao)
    }

    @Test
    fun getProducts() = runTest {
        // Given
        val mockDao = mockk<ProductsDao>()
        val mockService = mockk<ProductsService>()
        val productList = listOf(
            ProductEntity(1, "Product 1", "Description 1", 5f),
            ProductEntity(2, "Product 2", "Description 2", 5f)
        )
        val remoteData = ProductsResponse(productList.toProductRemoteList())

        coEvery { mockDao.getProductList() } returns productList
        coEvery { mockDao.insert(productList) } just Runs
        coEvery { mockService.getProductList() } returns remoteData


        coVerify(exactly = 0) { mockDao.insert(productList) }
    }

    @Test
    fun getProductDetail() = runTest {
        val idToFind = 1
        val idCaptor = slot<Int>()

        repository.getProductDetail(idToFind)

        coVerify { dao.getProduct(capture(idCaptor)) }

        assertEquals(idToFind, idCaptor.captured)
    }
}