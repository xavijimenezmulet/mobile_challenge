@file:Suppress("DEPRECATION")

package com.xavijimenezmulet.products.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.xavijimenezmulet.products.list.ProductsViewModel
import com.xavijimenezmulet.products.list.ProductsViewState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.xavijimenezmulet.framework.base.jetpack.rememberFlowWithLifecycle
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.utils.extension.orZero

@Composable
fun ProductContent(
    viewModel: ProductsViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    viewState: ProductsViewState,
    selectItem: (Int) -> Unit = {}
) {
    val pagingItems = rememberFlowWithLifecycle(viewState.pagedData).collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState(
            isRefreshing = pagingItems.loadState.refresh == LoadState.Loading
        ),
        onRefresh = { pagingItems.refresh() },
        indicatorPadding = paddingValues,
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                scale = true
            )
        },
        modifier = Modifier.background(MobileChallengeColors.background),
        content = {
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 4.dp)
                    .background(MobileChallengeColors.background),
            ) {
                items(pagingItems.itemCount) { index ->
                    pagingItems[index]?.let {
                        ProductRow(
                            viewModel,
                            dto = it,
                            onDetailClick = { selectItem.invoke(it.id.orZero()) }
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
        }
    )
}