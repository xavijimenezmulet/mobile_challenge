package com.xavijimenezmulet.utils.utils.cart

import androidx.paging.compose.LazyPagingItems
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
            count = if (isSum) cart.count + 1 else cart.count -1,
            name = cart.name,
            price = cart.price
        )
    }

    fun calculateSubtotal(array: LazyPagingItems<Cart>) : String {
        var price = 0f
        for (i in 0 until array.itemCount) {
            val c = array[i]
            c?.let {
                price += c.count * c.price
            }
        }
        return price.toCurrency()
    }

    fun calculateDiscounts(array: LazyPagingItems<Cart>) : String {
        var price = 0f
        for (i in 0 until array.itemCount) {
            val c = array[i]
            c?.let {
                price += c.count * c.price
            }
        }
        return price.toCurrency()
    }

    private fun calculate2x1Discount(cart: Cart): Float {
        return 0f
    }
}