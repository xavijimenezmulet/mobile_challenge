package com.xavijimenezmulet.cart

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.framework.base.mvi.MviViewModel
import com.xavijimenezmulet.usecase.cart.GetCartList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartList: GetCartList,
) : MviViewModel<BaseViewState<CartViewState>, CartEvent>() {

    private val config = PagingConfig(pageSize = 0)

    override fun onTriggerEvent(eventType: CartEvent) {
        when (eventType) {
            is CartEvent.LoadCart -> onLoadCart()
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
}