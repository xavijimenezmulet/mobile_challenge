package com.xavijimenezmulet.usecase.cart

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.network.DataState
import com.xavijimenezmulet.framework.base.usecase.DataStateUseCase
import com.xavijimenezmulet.repository.cart.CartRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class GetCartProduct
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val cartRepository: CartRepository
) : DataStateUseCase<GetCartProduct.Params, Cart>() {

    data class Params(
        val code: String = ""
    )

    override suspend fun FlowCollector<DataState<Cart>>.execute(params: Params) {
        val product = cartRepository.getCartItem(code = params.code)
        product?.let {
            emit(DataState.Success(product))
        } ?: run {
            emit(DataState.Error(Throwable()))
        }
    }
}