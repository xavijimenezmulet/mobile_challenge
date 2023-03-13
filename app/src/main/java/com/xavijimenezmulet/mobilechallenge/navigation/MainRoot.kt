package com.xavijimenezmulet.mobilechallenge.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.xavijimenezmulet.framework.base.jetpack.SetupSystemUi
import com.xavijimenezmulet.mobilechallenge.provider.AppNavigationProvider
import com.xavijimenezmulet.provider.shouldUseDarkMode
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTheme

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@Composable
fun MainRoot(viewModel: MainViewModel = hiltViewModel(), finish: () -> Unit) {
    val navController = rememberNavController()

    val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()

    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()

    val destination = currentBackStackEntryAsState?.destination?.route
        ?: RootNavGraph.startRoute.startRoute.route

    if (destination == RootNavGraph.startRoute.startRoute.route) {
        BackHandler { finish() }
    }


    MobileChallengeTheme (darkTheme = isDarkMode) {
        SetupSystemUi(rememberSystemUiController(), MobileChallengeColors.primary)

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MobileChallengeColors.background
        ) {
            DestinationsNavHost(
                navController = navController,
                navGraph = RootNavGraph,
                dependenciesContainerBuilder = {
                    dependency(AppNavigationProvider(navController))
                }
            )
        }
    }
}