package com.xavijimenezmulet.usecase.cart

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.usecase.LocalUseCase
import com.xavijimenezmulet.repository.cart.CartRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class AddToCartProduct
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val cartRepository: CartRepository
) : LocalUseCase<AddToCartProduct.Params, Unit>() {

    data class Params(
        val cart: Cart? = null
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        cartRepository.saveCartItem(params.cart)
        emit(Unit)
    }
}