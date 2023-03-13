package com.xavijimenezmulet.repository.products

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.local.dao.ProductsDao
import com.xavijimenezmulet.remote.service.products.ProductsService
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsRepository
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val service: ProductsService,
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val dao: ProductsDao
) {
    suspend fun getProductList() = service.getProductList()
}