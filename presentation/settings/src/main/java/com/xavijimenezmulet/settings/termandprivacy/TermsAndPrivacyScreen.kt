package com.xavijimenezmulet.settings.termandprivacy

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.xavijimenezmulet.component.widget.MCToolbarWithNavIcon
import com.xavijimenezmulet.framework.base.jetpack.htmltext.HtmlText
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTypography
import com.xavijimenezmulet.theme.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun TermsAndPrivacyScreen(
    navigator: NavigationProvider
) {
    Scaffold(
        topBar = {
            MCToolbarWithNavIcon(
                R.string.text_term_and_privacy,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        },
        content = {
            Column(modifier = Modifier.background(MobileChallengeColors.surface)) {
                HtmlText(
                    text = termsAndConditions.plus(privacyPolicy),
                    modifier = Modifier
                        .padding(12.dp)
                        .verticalScroll(rememberScrollState()),
                    style = MobileChallengeTypography.headlineMedium
                )
            }
        }
    )
}