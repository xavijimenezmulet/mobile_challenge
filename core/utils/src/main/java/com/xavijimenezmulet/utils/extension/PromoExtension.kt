package com.xavijimenezmulet.utils.extension

import com.xavijimenezmulet.constants.Constants.PROMO_NONE
import com.xavijimenezmulet.constants.Constants.PROMO_TRUE
import com.xavijimenezmulet.constants.Constants.TYPE_VOUCHER

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

fun String.hasPromo() = (this == PROMO_TRUE)

fun String.codeToPromo() = if (this == TYPE_VOUCHER) PROMO_TRUE else PROMO_NONE