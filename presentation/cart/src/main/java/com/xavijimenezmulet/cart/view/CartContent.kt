@file:Suppress("DEPRECATION")

package com.xavijimenezmulet.cart.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.xavijimenezmulet.cart.CartViewModel
import com.xavijimenezmulet.cart.CartViewState
import com.xavijimenezmulet.component.widget.LottieEmptyView
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.jetpack.rememberFlowWithLifecycle
import com.xavijimenezmulet.theme.MobileChallengeColors

@Composable
fun CartContent(
    viewModel: CartViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    viewState: CartViewState,
    selectedDelete: MutableState<Cart?>,
    onDeleteItem: () -> Unit = {}
) {
    val pagingItems = rememberFlowWithLifecycle(viewState.pagedData).collectAsLazyPagingItems()

    if (pagingItems.itemCount == 0) {
        LottieEmptyView()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MobileChallengeColors.background),
        ) {
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier.weight(0.7f)
            ) {
                items(pagingItems.itemCount) { index ->
                    pagingItems[index]?.let {
                        CartRow(
                            viewModel,
                            dto = it,
                            selectedDelete = selectedDelete,
                            onDeleteItem = onDeleteItem
                        )
                    }
                }

                if (pagingItems.loadState.append == LoadState.Loading) {
                    item {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(24.dp)
                        ) {
                            CircularProgressIndicator(Modifier.align(Alignment.Center))
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .background(MobileChallengeColors.surface)
            ) {
                CartCheckout(pagingItems = pagingItems)
            }
        }
    }
}