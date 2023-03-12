package com.xavijimenezmulet.testutils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * @author xavierjimenez
 * @since 11/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
class TestCoroutineRule : TestRule {

    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    val testCoroutineScope = TestScope(testCoroutineDispatcher)

    override fun apply(base: Statement, description: Description): Statement =
        object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                Dispatchers.setMain(testCoroutineDispatcher)

                base.evaluate()

                Dispatchers.resetMain()
            }
        }

    fun runTest(block: suspend TestScope.() -> Unit) =
        testCoroutineScope.runTest { block() }
}