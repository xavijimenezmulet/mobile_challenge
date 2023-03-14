package com.xavijimenezmulet.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.xavijimenezmulet.theme.R

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
enum class BottomBarHomeItem(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    PRODUCTS(
        title = R.string.bottom_menu_products,
        icon = Icons.Filled.Home
    ),
    EPISODES(
        title = R.string.bottom_menu_products,
        icon = Icons.Filled.Dashboard
    ),
    LOCATIONS(
        title = R.string.bottom_menu_products,
        icon = Icons.Filled.LocationCity
    ),
    SETTINGS(
        title = R.string.bottom_menu_settings,
        icon = Icons.Filled.Settings
    );
}