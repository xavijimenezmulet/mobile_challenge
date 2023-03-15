@file:OptIn(
    ExperimentalMaterialApi::class, ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class, ExperimentalMaterialApi::class, ExperimentalMaterialApi::class
)

package com.xavijimenezmulet.cart

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavijimenezmulet.cart.view.CartContent
import com.xavijimenezmulet.cart.view.RemoveBottomSheetContent
import com.xavijimenezmulet.component.widget.EmptyView
import com.xavijimenezmulet.component.widget.ErrorView
import com.xavijimenezmulet.component.widget.LoadingView
import com.xavijimenezmulet.component.widget.MCToolbar
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTheme
import com.xavijimenezmulet.theme.R
import com.xavijimenezmulet.utils.extension.cast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()
    val selectedDelete: MutableState<Cart?> = remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    CartBody(
        modifier, bottomSheetState,
        sheetContent = {
            RemoveBottomSheetContent(
                cart = selectedDelete.value,
                onCancel = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                },
                onApprove = {
                    coroutineScope.launch {
                        selectedDelete.value?.let {
                            viewModel.onTriggerEvent(CartEvent.DeleteItem(it))
                            bottomSheetState.hide()
                        }
                    }
                }
            )
        }
    ) { padding ->
        Column {
            CartPage(
                uiState,
                viewModel,
                padding,
                navigator,
                modifier,
                selectedDelete,
                coroutineScope,
                bottomSheetState
            )
        }
    }
}

@Composable
private fun CartPage(
    uiState: BaseViewState<*>,
    viewModel: CartViewModel,
    paddings: PaddingValues,
    navigator: NavigationProvider,
    modifier: Modifier,
    selectedDelete: MutableState<Cart?>,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
) {
    when (uiState) {
        is BaseViewState.Data -> {
            CartContent(
                viewModel = viewModel,
                paddingValues = paddings,
                viewState = uiState.cast<BaseViewState.Data<CartViewState>>().value,
                selectedDelete = selectedDelete,
                onDeleteItem = {
                    coroutineScope.launch {
                        if (bottomSheetState.isVisible) {
                            bottomSheetState.hide()
                        } else {
                            bottomSheetState.show()
                        }
                    }
                }
            )
        }
        is BaseViewState.Empty -> EmptyView(modifier = modifier)
        is BaseViewState.Error -> ErrorView(
            e = uiState.cast<BaseViewState.Error>().throwable,
            action = {
                viewModel.onTriggerEvent(CartEvent.LoadCart)
            }
        )
        is BaseViewState.Loading -> LoadingView()
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(CartEvent.LoadCart)
    })
}

@Composable
private fun CartBody(
    modifier: Modifier = Modifier,
    bottomSheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    ModalBottomSheetLayout(
        sheetContent = sheetContent,
        modifier = modifier
            .fillMaxSize()
            .background(MobileChallengeColors.background),
        sheetState = bottomSheetState,
        sheetContentColor = MobileChallengeColors.background,
        sheetShape = RectangleShape,
        content = {
            Scaffold(
                topBar = { MCToolbar(R.string.bottom_menu_cart, elevation = 0.dp) },
                content = { pageContent.invoke(it) }
            )
        }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun CartScreenPreview() {
    MobileChallengeTheme {
        Surface {
        }
    }
}