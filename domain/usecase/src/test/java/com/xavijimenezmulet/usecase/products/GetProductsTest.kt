@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.usecase.products

import androidx.paging.PagingConfig
import com.xavijimenezmulet.repository.products.ProductsRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class GetProductsTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var repository: ProductsRepository

    @SpyK
    @InjectMockKs
    private lateinit var getCharacters: GetProducts

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val pagingConfig = PagingConfig(pageSize = 20)
        val params = GetProducts.Params(pagingConfig)

        // Act (When)
        getCharacters.invoke(params)

        // Assert (Then)
        coVerify { getCharacters.invoke(any()) }
    }
}