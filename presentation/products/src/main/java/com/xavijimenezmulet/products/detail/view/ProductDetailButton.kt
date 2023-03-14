package com.xavijimenezmulet.products.detail.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.products.detail.ProductDetailEvent
import com.xavijimenezmulet.products.detail.ProductDetailViewModel
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.theme.R
import com.xavijimenezmulet.theme.Red700
import com.xavijimenezmulet.theme.White
import com.xavijimenezmulet.utils.extension.toast

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

@Composable
fun ProductDetailButton(
    product: Product,
    navigator: NavigationProvider? = null,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val infoText = stringResource(id = R.string.text_product_add_to_cart)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.onTriggerEvent(ProductDetailEvent.AddToCart(product))
                context.toast(infoText)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Red700
            ),
            shape = RectangleShape
        ) {
            Text(
                text = stringResource(id = R.string.text_add_to_cart),
                color = White,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}