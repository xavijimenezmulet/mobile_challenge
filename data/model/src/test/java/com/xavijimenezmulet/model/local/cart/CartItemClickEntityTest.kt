package com.xavijimenezmulet.model.local.cart

import com.xavijimenezmulet.model.local.products.ProductEntity
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class CartItemClickEntityTest {
    @Test
    fun checkCorrectAttributes() {
        val name = "Voucher"
        val code = "VOUCHER"
        val price = 5f
        val promo = "NONE"
        val count = 20

        val entity = CartItemClickEntity(
            name = name,
            code = code,
            price = price,
            promo = promo,
            count = count
        )

        assertEquals(name, entity.name)
        assertEquals(code, entity.code)
        assertEquals(price, entity.price)
        assertEquals(promo, entity.promo)
        assertEquals(count, entity.count)
    }
}