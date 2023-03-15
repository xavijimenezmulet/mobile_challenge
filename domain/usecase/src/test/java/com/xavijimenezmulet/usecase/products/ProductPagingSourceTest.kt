@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.usecase.products

import androidx.paging.PagingSource
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.repository.products.ProductsRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductPagingSourceTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var repository: ProductsRepository

    @InjectMockKs
    lateinit var pagingSource: ProductPagingSource


    @Test
    fun `paging source load - failure - received null`() = runTest {
        // Arrange (Given)
        val error = NullPointerException()
        coEvery { repository.getProductList() } throws error

        // Act (When)
        val expectedResult = PagingSource.LoadResult.Error<Int, Product>(error)

        // Assert (Then)
        var exceptionThrown: Boolean = false
        try {
            assertEquals(
                expectedResult.toString(),
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = 0,
                        loadSize = 1,
                        placeholdersEnabled = false
                    )
                ).toString()
            )
        } catch (exception: NullPointerException) {
            // Maybe put some assertions on the exception here.
            exceptionThrown = true
        }
        assertTrue(exceptionThrown)
    }

    @Test
    fun `paging source load - failure - received http error`() = runTest {
        // Arrange (Given)
        val error = RuntimeException("404", Throwable())
        coEvery { repository.getProductList() }.throws(error)

        // Act (When)
        val expectedResult = PagingSource.LoadResult.Error<Int, Product>(error)
        // Assert (Then)
        var exceptionThrown: Boolean = false
        try {
            assertEquals(
                expectedResult.toString(),
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = 0,
                        loadSize = 1,
                        placeholdersEnabled = false
                    )
                ).toString()
            )
        } catch (exception: RuntimeException) {
            // Maybe put some assertions on the exception here.
            exceptionThrown = true
        }
        assertTrue(exceptionThrown)
    }
}