package com.xavijimenezmulet.mobilechallenge.provider

import androidx.navigation.NavController
import com.xavijimenezmulet.provider.NavigationProvider

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
}