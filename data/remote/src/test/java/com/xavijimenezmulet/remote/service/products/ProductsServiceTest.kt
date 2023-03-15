@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.remote.service.products

import com.xavijimenezmulet.remote.mock.MockResponses
import com.xavijimenezmulet.testutils.BaseServiceTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsServiceTest: BaseServiceTest<ProductsService>(ProductsService::class) {

    override val baseUrl: String = "https://gist.githubusercontent.com/"

    /**
     * Get Products List
     */
    @Test
    fun requestLiveGetProducts() = runTest {
        val response = serviceLive.getProductList()
        Assert.assertEquals("VOUCHER", response.products?.first()?.code)
        Assert.assertEquals("Cabify Voucher", response.products?.first()?.name)
        Assert.assertEquals(5f, response.products?.first()?.price)
    }

    @Test
    fun requestGetProducts() = runTest {
        enqueueResponse(MockResponses.GetProducts.STATUS_200)
        serviceMock.getProductList()
        val request = mockWebServer.takeRequest()
        Assert.assertEquals("GET", request.method)
        Assert.assertEquals("/palcalde/6c19259bd32dd6aafa327fa557859c2f/raw/ba51779474a150ee4367cda4f4ffacdcca479887/Products.json", request.path)
    }

    @Test
    fun responseGetProducts() = runTest {
        enqueueResponse(MockResponses.GetProducts.STATUS_200)
        val response = serviceMock.getProductList()
        Assert.assertEquals("VOUCHER", response.products?.first()?.code)
        Assert.assertEquals("Cabify Voucher", response.products?.first()?.name)
        Assert.assertEquals(5f, response.products?.first()?.price)
    }

}