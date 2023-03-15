package com.xavijimenezmulet.cart.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavijimenezmulet.cart.CartEvent
import com.xavijimenezmulet.cart.CartViewModel
import com.xavijimenezmulet.component.widget.MCDivider
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.theme.*
import com.xavijimenezmulet.theme.R
import com.xavijimenezmulet.utils.extension.toast
import com.xavijimenezmulet.utils.utils.cart.AddToCartUtils

/**
 *   @author xavierjimenez
 *   @since 15/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

@Composable
fun CartCheckout(
    cartList: List<Cart>,
    viewModel: CartViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        CartInfoCheckout(cartList = cartList)

        Spacer(Modifier.height(10.dp))

        CartButton(modifier = Modifier.fillMaxWidth(), onClick = {
            viewModel.onTriggerEvent(CartEvent.CheckoutFinish)
            context.toast(context.getString(R.string.text_order_thanks))
        }, cartList = cartList)

        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun CartInfoCheckout(
    viewModel: CartViewModel = hiltViewModel(),
    cartList: List<Cart>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.text_oder_information),
            modifier = Modifier
                .padding(12.dp),
            style = MobileChallengeTypography.titleLarge,
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MobileChallengeColors.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextRow(
                    key = stringResource(id = R.string.text_order_subtotal),
                    value = AddToCartUtils.calculateSubtotal(cartList as ArrayList<Cart>)
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_order_discount),
                    value = AddToCartUtils.calculateDiscounts(cartList)
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_order_total),
                    value = AddToCartUtils.calculateTotal(cartList)
                )
            }
        }
    }
}

@Composable
private fun TextRow(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = key,
            maxLines = 1,
            overflow = TextOverflow.Visible,
            style = MobileChallengeTypography.bodyMedium,
            textAlign = TextAlign.Start
        )
        Text(
            text = value,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MobileChallengeTypography.titleMedium,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun CartButton(
    modifier: Modifier,
    onClick: () -> Unit,
    viewModel: CartViewModel = hiltViewModel(),
    cartList: List<Cart>
) {
    Row(
        modifier = modifier
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = true
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Red700
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = stringResource(
                        id = R.string.text_finish_checkout,
                        AddToCartUtils.calculateTotal(cartList as ArrayList<Cart>)
                    ),
                    color = White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}