package com.xavijimenezmulet.entity.products

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductTest {
    @Test
    fun checkCorrectAttributes() {
        val id = 1
        val code = "VOUCHER"
        val name = "Voucher"
        val price = 5f

        val dto = Product(
            id = id,
            name = name,
            code = code,
            price = price
        )

        assertEquals(id, dto.id)
        assertEquals(name, dto.name)
        assertEquals(code, dto.code)
        assertEquals(price, dto.price)
    }
}