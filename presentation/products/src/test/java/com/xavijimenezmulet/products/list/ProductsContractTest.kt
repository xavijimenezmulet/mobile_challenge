package com.xavijimenezmulet.products.list

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsContractTest {
    private lateinit var event: ProductsEvent

    @Test
    fun verifyEventLoadProducts() {
        event = ProductsEvent.LoadProducts

        val eventLoadCart = event as ProductsEvent.LoadProducts
        assertEquals(event, eventLoadCart)
    }
}