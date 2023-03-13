package com.xavijimenezmulet.model.remote.products

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "code") val code: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "price") val price: Float?,
)