package com.xavijimenezmulet.usecase.mockdata

import com.xavijimenezmulet.entity.products.Product
import kotlinx.coroutines.flow.flow

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
object MockData {
    fun getProductsResponse() = flow {
        emit(listOf<Product>())
    }
}