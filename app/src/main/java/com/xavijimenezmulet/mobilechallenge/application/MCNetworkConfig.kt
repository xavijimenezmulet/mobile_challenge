package com.xavijimenezmulet.mobilechallenge.application

import com.xavijimenezmulet.framework.base.application.NetworkConfig
import com.xavijimenezmulet.mobilechallenge.BuildConfig

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class MCNetworkConfig : NetworkConfig() {
    override fun baseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun timeOut(): Long {
        return 30L
    }

    override fun isDev(): Boolean {
        return BuildConfig.DEBUG
    }
}