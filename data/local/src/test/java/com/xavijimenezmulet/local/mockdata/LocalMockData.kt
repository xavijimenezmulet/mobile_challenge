package com.xavijimenezmulet.local.mockdata

import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.model.local.products.ProductEntity

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
object LocalMockData {

    fun getProductsList(): List<ProductEntity> {
        return listOf(
            ProductEntity(
                id = 1,
                name = "Voucher",
                code = "VOUCHER",
                price = 5f
            )
        )
    }

    fun getCartList(): List<Cart> {
        return listOf(
            Cart(
                name = "Voucher",
                code = "VOUCHER",
                price = 5f,
                promo = "PROMO",
                count = 20
            ),
            Cart(
                name = "T-Shirt",
                code = "TSHIRT",
                price = 20f,
                promo = "PROMO",
                count = 20
            )
        )
    }
}