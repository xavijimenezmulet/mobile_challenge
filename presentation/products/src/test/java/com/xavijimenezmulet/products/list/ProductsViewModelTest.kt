package com.xavijimenezmulet.products.list

import androidx.compose.runtime.mutableStateOf
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.testutils.MockkUnitTest
import com.xavijimenezmulet.usecase.cart.AddToCartProduct
import com.xavijimenezmulet.usecase.cart.DeleteCartItem
import com.xavijimenezmulet.usecase.cart.DeleteCartList
import com.xavijimenezmulet.usecase.cart.GetCartList
import com.xavijimenezmulet.usecase.products.GetProducts
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsViewModelTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var getProducts: GetProducts

    @SpyK
    @InjectMockKs
    lateinit var viewModel: ProductsViewModel

    @Test
    fun verifyOnTriggerEventLoadGetProductList() = runTest {
        viewModel.onTriggerEvent(ProductsEvent.LoadProducts)

        coVerify { getProducts.invoke(any()) }
    }
}