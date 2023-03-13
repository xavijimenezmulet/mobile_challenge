package com.xavijimenezmulet.welcome

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.xavijimenezmulet.framework.base.jetpack.SetupSystemUi
import com.xavijimenezmulet.provider.LanguageProvider
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTheme
import com.xavijimenezmulet.welcome.navgraph.WelcomeNavGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@AndroidEntryPoint
class WelcomeActivity : FragmentActivity() {
    @Inject
    lateinit var languageProvider: LanguageProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            languageProvider.setLocale(languageProvider.getLanguageCode(), LocalContext.current)
            WelcomeRoot()
        }
    }
}

@Composable
private fun WelcomeRoot() {
    MobileChallengeTheme {
        SetupSystemUi(rememberSystemUiController(), MobileChallengeColors.primary)
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MobileChallengeColors.background
        ) {
            WelcomeNavGraph()
        }
    }
}