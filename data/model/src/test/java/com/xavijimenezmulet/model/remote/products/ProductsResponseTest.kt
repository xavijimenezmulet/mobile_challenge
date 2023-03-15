package com.xavijimenezmulet.model.remote.products

import com.xavijimenezmulet.testutils.BaseModelTest
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsResponseTest : BaseModelTest() {

    override fun checkModelClass(): Class<*> {
        return ProductsResponse::class.java
    }

    override fun checkModelFields(): List<String> {
        return listOf(
            "products"
        )
    }

    @Test
    fun createResponse() {
        val product: ProductResponse = mockk()

        val response = ProductsResponse(
            products = listOf(product)
        )

        assertEquals(product, response.products?.first())
    }
}