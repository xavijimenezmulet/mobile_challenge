@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package com.xavijimenezmulet.products.list

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavijimenezmulet.component.widget.EmptyView
import com.xavijimenezmulet.component.widget.ErrorView
import com.xavijimenezmulet.component.widget.LoadingView
import com.xavijimenezmulet.component.widget.MCToolbar
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.products.list.view.ProductContent
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTheme
import com.xavijimenezmulet.theme.R
import com.xavijimenezmulet.utils.extension.cast

@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductsViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()

    ProductsBody(
        modifier, bottomSheetState
    ) { padding ->
        Column {
            ProductsPage(uiState, viewModel, padding, navigator, modifier)
        }
    }
}

@Composable
private fun ProductsPage(
    uiState: BaseViewState<*>,
    viewModel: ProductsViewModel,
    paddings: PaddingValues,
    navigator: NavigationProvider,
    modifier: Modifier
) {
    when (uiState) {
        is BaseViewState.Data -> ProductContent(
            viewModel = viewModel,
            paddingValues = paddings,
            viewState = uiState.cast<BaseViewState.Data<CharactersViewState>>().value,
            selectItem = { id -> navigator.openProductDetail(id) }
        )
        is BaseViewState.Empty -> EmptyView(modifier = modifier)
        is BaseViewState.Error -> ErrorView(
            e = uiState.cast<BaseViewState.Error>().throwable,
            action = {
                viewModel.onTriggerEvent(ProductsEvent.LoadProducts)
            }
        )
        is BaseViewState.Loading -> LoadingView()
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(ProductsEvent.LoadProducts)
    })
}

@Composable
private fun ProductsBody(
    modifier: Modifier = Modifier,
    bottomSheetState: ModalBottomSheetState,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    ModalBottomSheetLayout(
        sheetContent = {},
        modifier = modifier
            .fillMaxSize()
            .background(MobileChallengeColors.background),
        sheetState = bottomSheetState,
        sheetContentColor = MobileChallengeColors.background,
        sheetShape = RectangleShape,
        content = {
            Scaffold(
                topBar = { MCToolbar(R.string.bottom_menu_products, elevation = 0.dp) },
                content = { pageContent.invoke(it) }
            )
        }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun CharactersScreenPreview() {
    MobileChallengeTheme {
        Surface {
        }
    }
}