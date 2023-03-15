package com.xavijimenezmulet.usecase.di

import com.xavijimenezmulet.repository.products.ProductsRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class ProductsDomainModuleTest : MockkUnitTest() {

    private lateinit var module: ProductsDomainModule

    override fun onCreate() {
        super.onCreate()
        module = ProductsDomainModule()
    }

    @Test
    fun verifyProvideGetProducts() {
        val repository = mockk<ProductsRepository>()
        val getCharacterList = module.provideGetProducts(repository)

        assertEquals(repository, getCharacterList.repository)
    }

    @Test
    fun verifyProvideGetProductDetail() {
        val repository = mockk<ProductsRepository>()
        val getCharacterDetail = module.provideGetProductDetail(repository)

        assertEquals(repository, getCharacterDetail.productsRepository)
    }
}