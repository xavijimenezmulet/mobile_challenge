package com.xavijimenezmulet.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.xavijimenezmulet.settings.view.SettingsContent
import com.ramcosta.composedestinations.annotation.Destination
import com.xavijimenezmulet.component.widget.MCToolbar
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.theme.MobileChallengeTheme
import com.xavijimenezmulet.theme.R

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@Destination(start = true)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    val checkedState = remember { mutableStateOf(viewModel.isNightMode()) }

    SettingsBody(modifier) {
        SettingsContent(viewModel, checkedState, navigator)
    }
}

@Composable
private fun SettingsBody(
    modifier: Modifier = Modifier,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { MCToolbar(R.string.bottom_menu_settings) },
        content = { pageContent.invoke(it) }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun SettingsScreenPreview() {
    MobileChallengeTheme {
        Surface {
            SettingsBody {
            }
        }
    }
}