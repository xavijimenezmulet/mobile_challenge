package com.xavijimenezmulet.mobilechallenge.provider

import android.content.Context
import com.xavijimenezmulet.provider.ResourceProvider

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class AppResourceProvider(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}