package com.xavijimenezmulet.cart

import androidx.compose.runtime.MutableState
import androidx.paging.PagingConfig
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.framework.base.mvi.MviViewModel
import com.xavijimenezmulet.usecase.cart.AddToCartProduct
import com.xavijimenezmulet.usecase.cart.DeleteCartItem
import com.xavijimenezmulet.usecase.cart.GetCartList
import com.xavijimenezmulet.utils.utils.cart.AddToCartUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartList: GetCartList,
    private val saveCartItem: AddToCartProduct,
    private val deleteItem: DeleteCartItem
) : MviViewModel<BaseViewState<CartViewState>, CartEvent>() {

    private val config = PagingConfig(pageSize = 0)

    override fun onTriggerEvent(eventType: CartEvent) {
        when (eventType) {
            is CartEvent.LoadCart -> onLoadFavorites()
            is CartEvent.RestItem -> onRestItem(eventType.cart, eventType.count)
            is CartEvent.AddItem -> onAddItem(eventType.cart, eventType.count)
            is CartEvent.DeleteItem -> onDeleteItem(eventType.cart)
        }
    }

    private fun onLoadFavorites() = safeLaunch {
        call(getCartList(Unit)) {
            if (it.isEmpty()) {
                setState(BaseViewState.Empty)
            } else {
                setState(BaseViewState.Data(CartViewState(cartList = it)))
            }
        }
    }

    private fun onRestItem(cart: Cart, count: MutableState<String>) = safeLaunch {
        val params =
            AddToCartProduct.Params(cart = AddToCartUtils.toRestSumItemCart(cart, false))
        count.value = params.cart?.count.toString()
        call(saveCartItem(params = params)) {
            onTriggerEvent(CartEvent.LoadCart)
        }
    }

    private fun onAddItem(cart: Cart, count: MutableState<String>) = safeLaunch {
        val params =
            AddToCartProduct.Params(cart = AddToCartUtils.toRestSumItemCart(cart, true))
        count.value = params.cart?.count.toString()
        call(saveCartItem(params = params)) {
            onTriggerEvent(CartEvent.LoadCart)
        }
    }

    private fun onDeleteItem(cart: Cart) = safeLaunch {
        call(deleteItem(DeleteCartItem.Params(cart))) {
            onTriggerEvent(CartEvent.LoadCart)
        }
    }
}