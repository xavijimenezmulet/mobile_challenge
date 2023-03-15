@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.usecase.products

import com.xavijimenezmulet.repository.products.ProductsRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class GetProductDetailTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var repository: ProductsRepository

    @SpyK
    @InjectMockKs
    private lateinit var productDetail: GetProductDetail

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val detailId = -1

        // Act (When)
        val params = GetProductDetail.Params(detailId = detailId)
        productDetail.invoke(params)

        // Assert (Then)
        coVerify { productDetail.invoke(any()) }
    }

    @Test
    fun collectExecute() = runTest {
        // Arrange (Given)
        val detailId = 1

        // Act (When)
        val param = GetProductDetail.Params(detailId = detailId)
        productDetail.invoke(param).single()

        // Assert (Then)
        coVerify { repository.getProductDetail(detailId) }
    }
}