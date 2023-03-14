package com.xavijimenezmulet.entity.products

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

@Parcelize
data class Product(
    val id: Int,
    val code: String,
    val name: String,
    val price: Float?
) : Parcelable