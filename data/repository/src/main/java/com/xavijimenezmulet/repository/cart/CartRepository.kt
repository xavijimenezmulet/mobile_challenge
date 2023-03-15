package com.xavijimenezmulet.repository.cart

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.model.dto.cart.toCartDtoList
import com.xavijimenezmulet.model.dto.cart.toCartItem
import com.xavijimenezmulet.model.dto.cart.toCartItemEntity
import com.xavijimenezmulet.model.local.cart.CartItemClickEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class CartRepository
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val dao: CartDao
) {
    suspend fun getCartItemList() = dao.getCartItemList().toCartDtoList()

    suspend fun getCartItem(code: String): Cart? = dao.getCartItem(code)?.toCartItem()

    suspend fun saveCartItem(cartItem: Cart?) {
        cartItem?.let {
            dao.insert(cartItem.toCartItemEntity())
        }
    }

    suspend fun deleteCartItem(cartItem: Cart) = dao.deleteItem(cartItem.code)
}