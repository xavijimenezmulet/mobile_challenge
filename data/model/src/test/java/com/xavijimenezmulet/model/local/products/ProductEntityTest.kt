package com.xavijimenezmulet.model.local.products

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductEntityTest {
    @Test
    fun checkCorrectAttributes() {
        val id = 1
        val name = "Voucher"
        val code = "VOUCHER"
        val price = 5f

        val entity = ProductEntity(
            id = id,
            name = name,
            code = code,
            price = price
        )

        assertEquals(id, entity.id)
        assertEquals(name, entity.name)
        assertEquals(code, entity.code)
        assertEquals(price, entity.price)
    }
}