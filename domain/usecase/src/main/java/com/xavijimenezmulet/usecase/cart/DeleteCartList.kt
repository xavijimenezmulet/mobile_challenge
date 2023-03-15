package com.xavijimenezmulet.usecase.cart

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.framework.base.usecase.LocalUseCase
import com.xavijimenezmulet.repository.cart.CartRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class DeleteCartList @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CartRepository
) : LocalUseCase<Unit, Unit>() {

    override suspend fun FlowCollector<Unit>.execute(params: Unit) {
        repository.deleteCartList()
        emit(Unit)
    }
}