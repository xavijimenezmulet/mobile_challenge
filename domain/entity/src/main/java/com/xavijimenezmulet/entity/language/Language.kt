package com.xavijimenezmulet.entity.language

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
data class Language(
    val id: Int,
    val code: String,
    val name: String,
    var isSelected: Boolean = false
)