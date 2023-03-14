package com.xavijimenezmulet.settings

import androidx.lifecycle.ViewModel
import com.xavijimenezmulet.provider.ThemeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themeProvider: ThemeProvider
) : ViewModel() {

    fun isNightMode() = themeProvider.isNightMode()

    fun saveThemeMode(isChecked: Boolean) {
        themeProvider.theme = if (isChecked) {
            ThemeProvider.Theme.DARK
        } else {
            ThemeProvider.Theme.LIGHT
        }
    }
}