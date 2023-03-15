package com.xavijimenezmulet.products.detail


import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.framework.base.mvi.MviViewModel
import com.xavijimenezmulet.usecase.cart.AddToCartProduct
import com.xavijimenezmulet.usecase.cart.GetCartProduct
import com.xavijimenezmulet.usecase.products.GetProductDetail
import com.xavijimenezmulet.utils.utils.cart.AddToCartUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetail: GetProductDetail,
    private val addToCartProduct: AddToCartProduct,
    private val getCartProduct: GetCartProduct
) : MviViewModel<BaseViewState<ProductDetailViewState>, ProductDetailEvent>() {

    var cart: Cart? = null
    private lateinit var currentProduct: Product

    override fun onTriggerEvent(eventType: ProductDetailEvent) {
        when (eventType) {
            is ProductDetailEvent.LoadProduct -> onLoadDetail(eventType.id)
            is ProductDetailEvent.AddToCart -> onAddToCart(eventType.product)
            is ProductDetailEvent.ForceAddToCart -> onForceAddToCart()
        }
    }

    private fun onLoadDetail(id: Int) = safeLaunch {
        val params = GetProductDetail.Params(detailId = id)
        execute(getProductDetail(params)) { dto ->
            setState(BaseViewState.Data(ProductDetailViewState(product = dto)))
        }
    }

    private fun onAddToCart(product: Product) = safeLaunch {
        cart = null
        currentProduct = product
        val params = GetCartProduct.Params(product = currentProduct)
        execute(getCartProduct(params)) { dto ->
            cart = dto
            onForceAddToCart()
        }
    }

    private fun onForceAddToCart() = safeLaunch {
        val params =
            AddToCartProduct.Params(cart = AddToCartUtils.getCartForAdd(cart, currentProduct))
        call(addToCartProduct(params = params)) {
            setState(BaseViewState.Error(Throwable("toUp")))
        }
    }
}