package com.xavijimenezmulet.usecase.cart

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.usecase.FlowPagingUseCase
import com.xavijimenezmulet.framework.base.usecase.LocalUseCase
import com.xavijimenezmulet.repository.cart.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class GetCartList @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CartRepository
) : LocalUseCase<Unit, List<Cart>>() {

    override suspend fun FlowCollector<List<Cart>>.execute(params: Unit) {
        val favors = repository.getCartItemList()
        emit(favors)
    }
}