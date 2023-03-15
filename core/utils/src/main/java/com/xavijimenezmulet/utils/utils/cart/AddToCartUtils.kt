package com.xavijimenezmulet.utils.utils.cart

import com.xavijimenezmulet.constants.Constants
import com.xavijimenezmulet.constants.Constants.TYPE_T_SHIRT
import com.xavijimenezmulet.constants.Constants.TYPE_VOUCHER
import com.xavijimenezmulet.constants.Constants.T_SHIRT_PROMO
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.utils.extension.codeToPromo
import com.xavijimenezmulet.utils.extension.toCurrency

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
object AddToCartUtils {
    fun getCartForAdd(localCart: Cart? = null, product: Product): Cart {
        localCart?.let {
            val count = it.count
            return Cart(
                code = it.code,
                promo = it.promo,
                count = count + 1,
                name = it.name,
                price = it.price
            )
        } ?: run {
            return Cart(
                code = product.code,
                promo = product.code.codeToPromo(),
                count = 1,
                name = product.name,
                price = product.price ?: 0f
            )
        }
    }

    fun toRestSumItemCart(cart: Cart, isSum: Boolean): Cart {
        return Cart(
            code = cart.code,
            promo = cart.promo,
            count = if (isSum) cart.count + 1 else cart.count - 1,
            name = cart.name,
            price = cart.price
        )
    }

    fun calculateSubtotal(array: ArrayList<Cart>): String {
        var price = 0f
        array.forEach { c ->
            price += c.count * c.price
        }
        return price.toCurrency()
    }

    fun calculateTotal(array: ArrayList<Cart>): String {
        val subtotal = calculateSubtotalPrice(array)
        val discounts = calculateDiscountsPrice(array)
        val total = subtotal - discounts
        return total.toCurrency()
    }

    fun calculateDiscounts(array: ArrayList<Cart>): String {
        return calculateDiscountsPrice(array).toCurrency()
    }

    private fun calculateSubtotalPrice(array: ArrayList<Cart>): Float {
        var price = 0f
        array.forEach { c ->
            price += c.count * c.price
        }

        return price
    }

    private fun calculateDiscountsPrice(array: ArrayList<Cart>): Float {
        var price = 0f
        array.forEach {
            when(it.code) {
                TYPE_VOUCHER -> price += calculate2x1Discount(it)
                TYPE_T_SHIRT -> price += calculateTShirtDiscount(it)
            }
        }

        return price
    }

    private fun calculate2x1Discount(cart: Cart): Float {
        if (cart.code == TYPE_VOUCHER) {
            return if (arePrimes(cart.count)) {
                (cart.price / 2) * cart.count
            } else {
                (cart.price / 2) * (cart.count -1)
            }
        }
        return 0f
    }

    private fun calculateTShirtDiscount(cart: Cart): Float {
        if (cart.code == TYPE_T_SHIRT) {
            if (cart.count >= T_SHIRT_PROMO) {
                return cart.count.toFloat()
            }
        }
        return 0f
    }

    private fun arePrimes(number: Int) : Boolean {
        return (number % 2 == 0)
    }

}