package com.xavijimenezmulet.repository.mockdata

import com.xavijimenezmulet.model.local.cart.CartItemClickEntity
import com.xavijimenezmulet.model.local.products.ProductEntity

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
object RepositoryMockData {
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

    fun getCartList(): List<CartItemClickEntity> {
        return listOf(
            CartItemClickEntity(
                name = "Voucher",
                code = "VOUCHER",
                price = 5f,
                promo = "PROMO",
                count = 20
            ),
            CartItemClickEntity(
                name = "T-Shirt",
                code = "TSHIRT",
                price = 20f,
                promo = "NONE",
                count = 20
            )
        )
    }
}