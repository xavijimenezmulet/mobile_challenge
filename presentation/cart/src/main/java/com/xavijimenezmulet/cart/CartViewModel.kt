package com.xavijimenezmulet.cart

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
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
            is CartEvent.LoadCart -> onLoadCart()
            is CartEvent.RestItem -> onRestItem(eventType.cart)
            is CartEvent.AddItem -> onAddItem(eventType.cart)
            is CartEvent.DeleteItem -> onDeleteItem(eventType.cart)
        }
    }

    private fun onLoadCart() = safeLaunch {
        setState(BaseViewState.Loading)
        val params = GetCartList.Params(config)
        val pagedFlow = getCartList(params).cachedIn(scope = viewModelScope)
        pagedFlow.collect {
            setState(BaseViewState.Data(CartViewState(pagedData = pagedFlow)))
        }
    }

    private fun onRestItem(cart: Cart) = safeLaunch {
        val params =
            AddToCartProduct.Params(cart = AddToCartUtils.toRestSumItemCart(cart, false))
        call(saveCartItem(params = params))
        onUpdateCart()
    }

    private fun onAddItem(cart: Cart) = safeLaunch {
        val params =
            AddToCartProduct.Params(cart = AddToCartUtils.toRestSumItemCart(cart, true))
        call(saveCartItem(params = params))
        onUpdateCart()
    }

    private fun onUpdateCart() = safeLaunch {
        val params = GetCartList.Params(config)
        val pagedFlow = getCartList(params).cachedIn(scope = viewModelScope)
        pagedFlow.collect {
            setState(BaseViewState.Data(CartViewState(pagedData = pagedFlow, update = true)))
        }
    }

    private fun onDeleteItem(cart: Cart) = safeLaunch {
        call(deleteItem(DeleteCartItem.Params(cart))) {
            onTriggerEvent(CartEvent.LoadCart)
        }
    }
}