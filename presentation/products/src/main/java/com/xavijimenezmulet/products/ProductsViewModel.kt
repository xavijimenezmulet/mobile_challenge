package com.xavijimenezmulet.products

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.framework.base.mvi.MviViewModel
import com.xavijimenezmulet.usecase.products.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProducts: GetProducts,
) : MviViewModel<BaseViewState<CharactersViewState>, ProductsEvent>() {

    private val config = PagingConfig(pageSize = 0)

    override fun onTriggerEvent(eventType: ProductsEvent) {
        when (eventType) {
            is ProductsEvent.LoadProducts -> onLoadProducts()
        }
    }

    private fun onLoadProducts() = safeLaunch {
        setState(BaseViewState.Loading)
        val params = GetProducts.Params(config)
        val pagedFlow = getProducts(params).cachedIn(scope = viewModelScope)
        setState(BaseViewState.Data(CharactersViewState(pagedData = pagedFlow)))
    }
}