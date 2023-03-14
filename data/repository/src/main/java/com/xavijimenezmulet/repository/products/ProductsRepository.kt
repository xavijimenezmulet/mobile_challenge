package com.xavijimenezmulet.repository.products

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.local.dao.ProductsDao
import com.xavijimenezmulet.model.dto.products.toProductDtoList
import com.xavijimenezmulet.model.dto.products.toProductEntityList
import com.xavijimenezmulet.remote.service.products.ProductsService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
    fun getProductList(): Flow<List<Product>> = flow {
        val localData = dao.getProductList()
        if (localData.isNotEmpty()) {
            emit(localData.toProductDtoList())
        } else {
            val remoteData = service.getProductList()
            val products = remoteData.products
            if (!products.isNullOrEmpty()) {
                dao.insert(products.toProductEntityList())
                emit(dao.getProductList().toProductDtoList())
            } else {
                emit(emptyList())
            }
        }
    }

    suspend fun getProductDetail(id: Int) = dao.getProduct(id)
}