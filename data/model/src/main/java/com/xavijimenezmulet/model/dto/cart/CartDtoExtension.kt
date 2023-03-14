package com.xavijimenezmulet.model.dto.cart

import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.model.local.cart.CartItemClickEntity

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

fun Cart.toCartItemEntity() = CartItemClickEntity(
    code = code,
    count = count,
    promo = promo
)

fun CartItemClickEntity.toCartItem() = Cart(
    code = code.orEmpty(),
    count = count,
    promo = promo
)