package com.xavijimenezmulet.products.detail.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.xavijimenezmulet.products.detail.ProductDetailViewState
import com.xavijimenezmulet.provider.NavigationProvider

@Composable
fun ProductDetailContent(
    data: ProductDetailViewState,
    navigator: NavigationProvider? = null
) {
    LazyColumn {
        data.product?.let { product ->
            item("header") {
                ProductDetailHeaderView()
            }

            item("contentInfo") {
                ProductDetailInfoView(product = product)
            }

            item("button") {
                ProductDetailButton(product = product, navigator)
            }
        }
    }
}