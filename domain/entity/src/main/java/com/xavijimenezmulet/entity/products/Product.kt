package com.xavijimenezmulet.entity.products

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
data class Product(
    val id: Int,
    val code: String,
    val name: String,
    val price: Float?
)