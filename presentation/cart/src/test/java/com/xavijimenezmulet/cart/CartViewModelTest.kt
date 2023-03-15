@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.cart

import androidx.compose.runtime.mutableStateOf
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.testutils.MockkUnitTest
import com.xavijimenezmulet.usecase.cart.AddToCartProduct
import com.xavijimenezmulet.usecase.cart.DeleteCartItem
import com.xavijimenezmulet.usecase.cart.DeleteCartList
import com.xavijimenezmulet.usecase.cart.GetCartList
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class CartViewModelTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var getCartList: GetCartList

    @RelaxedMockK
    lateinit var saveCartItem: AddToCartProduct

    @RelaxedMockK
    lateinit var deleteItem: DeleteCartItem

    @RelaxedMockK
    lateinit var deleteCartList: DeleteCartList

    @SpyK
    @InjectMockKs
    lateinit var viewModel: CartViewModel

    @Test
    fun verifyOnTriggerEventLoadGetCartList() = runTest {
        viewModel.onTriggerEvent(CartEvent.LoadCart)

        coVerify { getCartList.invoke(Unit) }
    }

    @Test
    fun verifyOnTriggerEventCheckoutFinish() = runTest {
        viewModel.onTriggerEvent(CartEvent.CheckoutFinish)

        coVerify { deleteCartList.invoke(Unit) }
    }

    @Test
    fun verifyOnTriggerEventDeleteItem() = runTest {

        val cart = mockk<Cart>()

        viewModel.onTriggerEvent(CartEvent.DeleteItem(cart))

        coVerify { deleteItem.invoke(DeleteCartItem.Params(cart)) }
    }

    @Test
    fun verifyOnTriggerEventSaveCartItemNotCall() = runTest {

        val cart = mockk<Cart>()
        val count = mutableStateOf("")

        viewModel.onTriggerEvent(CartEvent.AddItem(cart, count = count))

        coVerify(exactly = 0) { saveCartItem.invoke(AddToCartProduct.Params(cart)) }
    }
}