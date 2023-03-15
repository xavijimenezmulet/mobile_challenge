package com.xavijimenezmulet.entity.cart

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@Parcelize
class Cart(
    val code: String,
    val name: String,
    val count: Int,
    val promo: String,
    val price: Float
) : Parcelable