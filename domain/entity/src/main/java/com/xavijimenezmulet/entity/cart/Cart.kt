package com.xavijimenezmulet.entity.cart

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class Cart(
    val code: String,
    val name: String,
    val count: Int,
    val promo: String,
    val price: Float
)