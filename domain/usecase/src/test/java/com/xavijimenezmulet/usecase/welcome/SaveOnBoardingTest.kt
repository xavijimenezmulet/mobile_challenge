@file:OptIn(ExperimentalCoroutinesApi::class)

package com.xavijimenezmulet.usecase.welcome

import com.xavijimenezmulet.repository.welcome.WelcomeRepository
import com.xavijimenezmulet.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class SaveOnBoardingTest  : MockkUnitTest() {
    @RelaxedMockK
    lateinit var repository: WelcomeRepository

    @SpyK
    @InjectMockKs
    private lateinit var saveOnBoarding: SaveOnBoarding

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val params = SaveOnBoarding.Params(true)

        // Act (When)
        saveOnBoarding.invoke(params)

        // Assert (Then)
        coVerify { saveOnBoarding.invoke(any()) }
    }

    @Test
    fun collectExecute() = runTest {
        // Arrange (Given)
        val params = SaveOnBoarding.Params(true)

        // Act (When)
        saveOnBoarding.invoke(params).single()

        // Assert (Then)
        coVerify { repository.saveOnBoardingState(params.completed) }
    }

}