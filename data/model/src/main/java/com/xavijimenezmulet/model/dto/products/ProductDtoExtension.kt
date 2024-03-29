package com.xavijimenezmulet.model.dto.products

import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.model.local.products.ProductEntity
import com.xavijimenezmulet.model.remote.products.ProductResponse
import com.xavijimenezmulet.utils.extension.orZero

fun ProductEntity.toProductDto() = Product(
    id = id.orZero(),
    name = name.orEmpty(),
    code = code.orEmpty(),
    price = price
)

@JvmName("toProductDtoListProductEntity")
fun List<ProductEntity>.toProductDtoList() = map { it.toProductDto() }

@JvmName("toProductEntityListProductRemote")
fun List<ProductEntity>.toProductRemoteList() = map { it.toProductResponse()}

fun ProductResponse.toProductDto() = Product(
    id = 0,
    name = name.orEmpty(),
    code = code.orEmpty(),
    price = price
)

@JvmName("toProductDtoListProductResponse")
fun List<ProductResponse>.toProductDtoList() = map { it.toProductDto() }

fun Product.toProductEntity() = ProductEntity(
    id = id.orZero(),
    name = name,
    code = code,
    price = price
)

fun ProductEntity.toProductResponse() = ProductResponse(
    name = name,
    code = code,
    price = price
)


fun ProductResponse.toProductEntity() = ProductEntity(
    id = null,
    name = name,
    code = code,
    price = price
)

@JvmName("toProductResponseListProductEntity")
fun List<ProductResponse>.toProductEntityList() = map { it.toProductEntity() }