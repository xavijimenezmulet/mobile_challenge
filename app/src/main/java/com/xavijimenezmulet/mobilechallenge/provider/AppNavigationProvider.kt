package com.xavijimenezmulet.mobilechallenge.provider

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.xavijimenezmulet.provider.NavigationProvider
import com.xavijimenezmulet.settings.destinations.AboutScreenDestination
import com.xavijimenezmulet.settings.destinations.LanguageScreenDestination
import com.xavijimenezmulet.settings.destinations.TermsAndPrivacyScreenDestination

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {

    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun openProductDetail(id: Int) {
        navController.navigateUp()
    }

    override fun openTermAndPrivacy() {
        navController.navigate(TermsAndPrivacyScreenDestination)
    }

    override fun openAppLanguage() {
        navController.navigate(LanguageScreenDestination)
    }

    override fun openAbout() {
        navController.navigate(AboutScreenDestination)
    }
}