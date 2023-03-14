package com.xavijimenezmulet.usecase.products

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.framework.base.network.DataState
import com.xavijimenezmulet.framework.base.usecase.DataStateUseCase
import com.xavijimenezmulet.model.dto.products.toProductDto
import com.xavijimenezmulet.repository.products.ProductsRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetProductDetail
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val productsRepository: ProductsRepository
) : DataStateUseCase<GetProductDetail.Params, Product>() {

    data class Params(
        val url: String? = null,
        val detailId: Int = 0
    )

    override suspend fun FlowCollector<DataState<Product>>.execute(params: Params) {
        val product = productsRepository.getProductDetail(id = params.detailId)
        emit(DataState.Success(product.toProductDto()))
    }
}