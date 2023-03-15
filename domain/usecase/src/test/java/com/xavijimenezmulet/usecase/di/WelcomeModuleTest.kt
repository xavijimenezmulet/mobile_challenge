package com.xavijimenezmulet.usecase.di

import com.xavijimenezmulet.repository.welcome.WelcomeRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class WelcomeModuleTest : MockkUnitTest() {
    private lateinit var module: WelcomeModule

    @MockK
    private lateinit var repository: WelcomeRepository

    override fun onCreate() {
        super.onCreate()
        module = WelcomeModule()
    }

    @Test
    fun verifyProvideSaveOnBoarding() {
        val saveOnBoarding = module.provideSaveOnBoarding(repository)

        assertEquals(repository, saveOnBoarding.repository)
    }

    @Test
    fun verifyProvideReadOnBoarding() {
        val readOnBoarding = module.provideReadOnBoarding(repository)

        assertEquals(repository, readOnBoarding.repository)
    }
}