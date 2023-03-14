package com.xavijimenezmulet.utils.utils.cart

import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.utils.extension.codeToPromo

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
object AddToCartUtils {
    fun getCartForAdd(localCart: Cart? = null, code: String): Cart {
        localCart?.let {
            val count = it.count
            return Cart(
                code = it.code,
                promo = it.promo,
                count = count + 1
            )
        } ?: run {
            return Cart(
                code = code,
                promo = code.codeToPromo(),
                count = 1
            )
        }
    }
}