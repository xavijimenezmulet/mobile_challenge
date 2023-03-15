@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.products.detail

import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.products.list.ProductsEvent
import com.xavijimenezmulet.products.list.ProductsViewModel
import com.xavijimenezmulet.testutils.MockkUnitTest
import com.xavijimenezmulet.usecase.cart.AddToCartProduct
import com.xavijimenezmulet.usecase.cart.GetCartProduct
import com.xavijimenezmulet.usecase.products.GetProductDetail
import com.xavijimenezmulet.usecase.products.GetProducts
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.ArgumentMatchers.any

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductDetailViewModelTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var getProductDetail: GetProductDetail

    @RelaxedMockK
    lateinit var addToCartProduct: AddToCartProduct

    @RelaxedMockK
    lateinit var getCartProduct: GetCartProduct

    @SpyK
    @InjectMockKs
    lateinit var viewModel: ProductDetailViewModel

    @Test
    fun verifyOnTriggerEventLoadGetProductDetail() = runTest {
        val id = 1

        viewModel.onTriggerEvent(ProductDetailEvent.LoadProduct(id))

        coVerify { getProductDetail.invoke(GetProductDetail.Params(detailId = id)) }
    }

    @Test
    fun verifyOnTriggerEventAddToCart() = runTest {
        val product = mockk<Product>()

        viewModel.onTriggerEvent(ProductDetailEvent.AddToCart(product))

        coVerify { getCartProduct.invoke(GetCartProduct.Params(product)) }
    }

    @Test
    fun verifyOnTriggerEventGetCartProduct() = runTest {
        val product = mockk<Product>()

        viewModel.onTriggerEvent(ProductDetailEvent.AddToCart(product))

        coVerify { getCartProduct.invoke(GetCartProduct.Params(product)) }
    }
}