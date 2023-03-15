package com.xavijimenezmulet.entity.cart

import com.xavijimenezmulet.entity.products.Product
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class CartTest {
    @Test
    fun checkCorrectAttributes() {
        val code = "VOUCHER"
        val name = "Voucher"
        val price = 5f
        val promo = "NONE"
        val count = 5

        val dto = Cart(
            name = name,
            code = code,
            price = price,
            count = count,
            promo = promo
        )

        assertEquals(name, dto.name)
        assertEquals(code, dto.code)
        assertEquals(price, dto.price)
        assertEquals(count, dto.count)
        assertEquals(promo, dto.promo)
    }
}