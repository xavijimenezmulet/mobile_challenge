package com.xavijimenezmulet.provider

import androidx.annotation.StringRes

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
interface ResourceProvider {
    fun getString(@StringRes id: Int): String
}