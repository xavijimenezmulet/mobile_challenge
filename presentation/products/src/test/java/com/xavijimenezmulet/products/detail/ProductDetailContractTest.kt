package com.xavijimenezmulet.products.detail

import com.xavijimenezmulet.entity.products.Product
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductDetailContractTest {
    private lateinit var event: ProductDetailEvent

    @Test
    fun verifyEventLoadProduct() {
        val id = 1
        event = ProductDetailEvent.LoadProduct(id)

        val eventLoad = event as ProductDetailEvent.LoadProduct
        assertEquals(event, eventLoad)
    }

    @Test
    fun verifyEventForceAddToCart() {
        event = ProductDetailEvent.ForceAddToCart

        val eventLoad = event as ProductDetailEvent.ForceAddToCart
        assertEquals(event, eventLoad)
    }

    @Test
    fun verifyEventAddToCart() {
        val product = mockk<Product>()
        event = ProductDetailEvent.AddToCart(product)

        val eventLoad = event as ProductDetailEvent.AddToCart
        assertEquals(event, eventLoad)
    }
}