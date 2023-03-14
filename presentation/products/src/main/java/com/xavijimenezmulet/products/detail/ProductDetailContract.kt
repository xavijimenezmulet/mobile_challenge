package com.xavijimenezmulet.products.detail

import com.xavijimenezmulet.entity.products.Product

data class ProductDetailViewState(
    val product: Product? = null
)

sealed class ProductDetailEvent {
    data class LoadProduct(val id: Int) : ProductDetailEvent()
    data class AddToCart(val product: Product) : ProductDetailEvent()
    object ForceAddToCart : ProductDetailEvent()
}