package com.xavijimenezmulet.cart

import androidx.compose.runtime.mutableStateOf
import com.xavijimenezmulet.entity.cart.Cart
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class CartContractTest {
    private lateinit var event: CartEvent

    @Test
    fun verifyEventLoadCart() {
        event = CartEvent.LoadCart

        val eventLoadCart = event as CartEvent.LoadCart
        Assert.assertEquals(event, eventLoadCart)
    }

    @Test
    fun verifyEventAddItem() {
        val dto = mockk<Cart>()
        event = CartEvent.AddItem(dto, count = mutableStateOf(""))

        val cartEvent = event as CartEvent.AddItem
        Assert.assertEquals(dto, cartEvent.cart)
    }

    @Test
    fun verifyEventRestItem() {
        val dto = mockk<Cart>()
        event = CartEvent.RestItem(dto, count = mutableStateOf(""))

        val eventRestItem = event as CartEvent.RestItem
        Assert.assertEquals(event, eventRestItem)
    }

    @Test
    fun verifyEventDeleteItem() {
        val cart = mockk<Cart>()
        event = CartEvent.DeleteItem(cart)

        val eventDelete = event as CartEvent.DeleteItem
        Assert.assertEquals(event, eventDelete)
    }

    @Test
    fun verifyEventFinishCheckout() {
        event = CartEvent.CheckoutFinish

        val finish = event as CartEvent.CheckoutFinish
        Assert.assertEquals(event, finish)
    }
}