package com.xavijimenezmulet.products.detail


import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.framework.base.mvi.MviViewModel
import com.xavijimenezmulet.usecase.products.GetProductDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getProductDetail: GetProductDetail
) : MviViewModel<BaseViewState<ProductDetailViewState>, ProductDetailEvent>() {

    override fun onTriggerEvent(eventType: ProductDetailEvent) {
        when (eventType) {
            is ProductDetailEvent.LoadProduct -> onLoadDetail(eventType.id)
        }
    }

    private fun onLoadDetail(id: Int) = safeLaunch {
        val params = GetProductDetail.Params(detailId = id)
        execute(getProductDetail(params)) { dto ->
            setState(BaseViewState.Data(ProductDetailViewState(product = dto)))
        }
    }
}