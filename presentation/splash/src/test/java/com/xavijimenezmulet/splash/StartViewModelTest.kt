package com.xavijimenezmulet.splash

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.xavijimenezmulet.testutils.MockkUnitTest
import com.xavijimenezmulet.usecase.welcome.ReadOnBoarding
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author xavierjimenez
 * @since 11/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class StartViewModelTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var readOnBoarding: ReadOnBoarding

    @SpyK
    @InjectMockKs
    lateinit var viewModel: StartViewModel

    @Test
    fun verify_startViewModel_callReadOnBoarding() = runTest {
        viewModel.apply {
            init()
        }

        coVerify { readOnBoarding.invoke(Unit) }
        confirmVerified(readOnBoarding)
    }

    @Test
    fun verify_onReadOnBoarding_checkState() = runTest {
        coEvery { readOnBoarding.invoke(Unit) } returns flow {
            emit(any())
        }

        // Act (When)
        viewModel.apply {
            init()
        }

        // Assert (Then)
        viewModel.startWelcome.test {
            awaitItem().apply {
                Truth.assertThat(this).isNotNull()
                Truth.assertThat(this).isInstanceOf(java.lang.Boolean::class.java)
            }
        }
    }

}