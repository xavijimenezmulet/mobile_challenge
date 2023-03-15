package com.xavijimenezmulet.usecase.cart

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.usecase.LocalUseCase
import com.xavijimenezmulet.repository.cart.CartRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class DeleteCartItem @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CartRepository
) : LocalUseCase<DeleteCartItem.Params, Unit>() {

    data class Params(
        val cart: Cart
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.deleteCartItem(params.cart)
        emit(Unit)
    }
}