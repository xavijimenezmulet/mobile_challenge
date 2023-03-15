package com.xavijimenezmulet.remote.service.products

import com.xavijimenezmulet.model.remote.products.ProductsResponse
import retrofit2.http.*

/**
 *   @author xavierjimenez
 *   @since 10/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

interface ProductsService {

    @GET(PRODUCTS)
    suspend fun getProductList(): ProductsResponse

    companion object {
        const val PRODUCTS = "/palcalde/6c19259bd32dd6aafa327fa557859c2f/raw/ba51779474a150ee4367cda4f4ffacdcca479887/Products.json"
    }
}