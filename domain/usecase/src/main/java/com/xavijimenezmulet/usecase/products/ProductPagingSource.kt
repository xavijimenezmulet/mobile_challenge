package com.xavijimenezmulet.usecase.products

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.model.dto.products.toProductDtoList
import com.xavijimenezmulet.repository.products.ProductsRepository
import java.io.IOException

class ProductPagingSource(
    private val repository: ProductsRepository
) : PagingSource<Int, Product>() {

    // The refresh key is used for subsequent refresh calls to PagingSource.load after the initial load
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        // for first case it will be null, then we can pass some default value, in our case it's 1
        val page = params.key ?: 1
        return try {
            val response = repository.getProductList()
            val productList = response.products.orEmpty().toProductDtoList()

            LoadResult.Page(
                data = productList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (productList.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            // IOException for network failures.
            return LoadResult.Error(exception)
        }
    }
}