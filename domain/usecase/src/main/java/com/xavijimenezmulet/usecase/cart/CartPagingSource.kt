package com.xavijimenezmulet.usecase.cart

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.repository.cart.CartRepository
import java.io.IOException

class CartPagingSource(
    internal val repository: CartRepository
) : PagingSource<Int, Cart>() {

    // The refresh key is used for subsequent refresh calls to PagingSource.load after the initial load
    override fun getRefreshKey(state: PagingState<Int, Cart>): Int? {
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


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cart> {
        val page = params.key ?: 1
        return try {
            val productList = mutableListOf<Cart>()
            repository.getCartItemList().collect { productList.addAll(it) }


            LoadResult.Page(
                data = productList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (productList.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }
}