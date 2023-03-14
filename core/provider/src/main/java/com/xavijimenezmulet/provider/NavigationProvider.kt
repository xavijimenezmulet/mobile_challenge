package com.xavijimenezmulet.provider

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
interface NavigationProvider {
    fun navigateUp()
    fun openProductDetail(id: Int)
    fun openTermAndPrivacy()
    fun openAppLanguage()
    fun openAbout()
}