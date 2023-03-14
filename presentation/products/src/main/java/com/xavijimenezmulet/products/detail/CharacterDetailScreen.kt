package com.xavijimenezmulet.products.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.xavijimenezmulet.component.widget.EmptyView
import com.xavijimenezmulet.component.widget.ErrorView
import com.xavijimenezmulet.component.widget.LoadingView
import com.xavijimenezmulet.component.widget.MCToolbarWithNavIcon
import com.xavijimenezmulet.framework.base.mvi.BaseViewState
import com.xavijimenezmulet.products.detail.view.CharacterDetailContent
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTheme
import com.xavijimenezmulet.utils.extension.cast

@Destination(start = true)
@Composable
fun ProductDetailScreen(
    id: Int = 0,
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()

    CharacterDetailBody(pressOnBack = {
        navigator.navigateUp()
    }) {
        when (uiState) {
            is BaseViewState.Data -> CharacterDetailContent(
                data = uiState.cast<BaseViewState.Data<ProductDetailViewState>>().value,
                navigator = navigator
            )
            is BaseViewState.Empty -> EmptyView()
            is BaseViewState.Error -> ErrorView(
                e = uiState.cast<BaseViewState.Error>().throwable,
                action = {
                    viewModel.onTriggerEvent(ProductDetailEvent.LoadProduct(id))
                }
            )
            is BaseViewState.Loading -> LoadingView()
        }
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(ProductDetailEvent.LoadProduct(id))
    })
}

@Composable
private fun CharacterDetailBody(
    pressOnBack: () -> Unit = {},
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        backgroundColor = MobileChallengeColors.background,
        topBar = {
            MCToolbarWithNavIcon(
                com.xavijimenezmulet.theme.R.string.bottom_menu_products,
                pressOnBack = pressOnBack
            )
        },
        content = { pageContent.invoke(it) }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun CharacterDetailScreenPreview() {
    MobileChallengeTheme {
        Surface {
            CharacterDetailBody {
            }
        }
    }
}