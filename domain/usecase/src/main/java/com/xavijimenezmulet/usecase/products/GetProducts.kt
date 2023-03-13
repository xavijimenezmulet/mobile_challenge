package com.xavijimenezmulet.usecase.products

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.framework.base.usecase.FlowPagingUseCase
import com.xavijimenezmulet.repository.products.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProducts @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: ProductsRepository
) : FlowPagingUseCase<GetProducts.Params, Product>() {

    data class Params(
        val pagingConfig: PagingConfig
    )

    override fun execute(params: Params): Flow<PagingData<Product>> {
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = { ProductPagingSource(repository) }
        ).flow
    }
}