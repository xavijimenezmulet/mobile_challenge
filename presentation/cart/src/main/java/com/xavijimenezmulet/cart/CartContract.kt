package com.xavijimenezmulet.cart

import androidx.paging.PagingData
import com.xavijimenezmulet.entity.cart.Cart
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
data class CartViewState(
    val pagedData: Flow<PagingData<Cart>> = emptyFlow(),
    val update: Boolean = false
)

sealed class CartEvent {
    object LoadCart : CartEvent()
    data class RestItem(val cart: Cart) : CartEvent()
    data class AddItem(val cart: Cart) : CartEvent()
    data class DeleteItem(val cart: Cart) : CartEvent()
}