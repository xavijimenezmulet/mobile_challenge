@file:Suppress("DEPRECATION")

package com.xavijimenezmulet.cart.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavijimenezmulet.cart.CartViewModel
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.theme.MobileChallengeColors

@Composable
fun CartContent(
    viewModel: CartViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    cartList: List<Cart>,
    selectedDelete: MutableState<Cart?>,
    onDeleteItem: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MobileChallengeColors.background),
    ) {
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.weight(0.7f)
        ) {
            itemsIndexed(cartList, key = { _, item -> item.code }) { index, _ ->
                CartRow(
                    viewModel,
                    index = index,
                    selectedDelete = selectedDelete,
                    onDeleteItem = onDeleteItem,
                    cartList = cartList
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(0.5f)
                .background(MobileChallengeColors.surface)
        ) {
            CartCheckout(cartList = cartList)
        }
    }
}