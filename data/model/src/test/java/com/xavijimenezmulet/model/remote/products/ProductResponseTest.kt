package com.xavijimenezmulet.model.remote.products

import com.xavijimenezmulet.testutils.BaseModelTest
import io.mockk.mockk
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductResponseTest : BaseModelTest() {
    override fun checkModelClass(): Class<*> {
        return ProductResponse::class.java
    }

    override fun checkModelFields(): List<String> {
        return listOf(
            "code",
            "name",
            "price"
        )
    }

    @Test
    fun createResponse() {
        val locationInfo: ProductResponse = mockk()
        assertNotNull(locationInfo)
    }
}