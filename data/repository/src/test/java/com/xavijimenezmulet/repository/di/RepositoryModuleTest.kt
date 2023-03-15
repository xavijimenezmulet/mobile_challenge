package com.xavijimenezmulet.repository.di

import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.local.dao.products.ProductsDao
import com.xavijimenezmulet.remote.service.products.ProductsService
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class RepositoryModuleTest : MockkUnitTest(){
    private lateinit var repositoryModule: RepositoryModule

    override fun onCreate() {
        super.onCreate()
        repositoryModule = RepositoryModule()
    }

    @Test
    fun verifyProvideProductsRepository() {
        val service = mockk<ProductsService>()
        val dao = mockk<ProductsDao>()
        val repository = repositoryModule.provideProductsRepository(service, dao)

        assertEquals(service, repository.service)
        assertEquals(dao, repository.dao)
    }

    @Test
    fun verifyProvideCartRepository() {
        val dao = mockk<CartDao>()
        val repository = repositoryModule.provideCartRepository(dao)

        assertEquals(dao, repository.dao)
    }
}