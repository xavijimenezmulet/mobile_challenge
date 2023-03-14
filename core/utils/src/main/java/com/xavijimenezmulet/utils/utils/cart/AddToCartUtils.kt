package com.xavijimenezmulet.utils.utils.cart

import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.utils.extension.codeToPromo

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
}