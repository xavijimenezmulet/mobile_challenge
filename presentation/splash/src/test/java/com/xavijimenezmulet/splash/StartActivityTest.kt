package com.xavijimenezmulet.splash

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.xavijimenezmulet.framework.base.application.CustomApplicationTest_Application
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.annotation.Config


/**
 * @author xavierjimenez
 * @since 10/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@Config(application = CustomApplicationTest_Application::class)
class StartActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = activityScenarioRule<StartActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun startActivity_launchActivity_noReturn() {
        launchActivity<StartActivity>()
    }

    @Test
    fun startActivity_activity_notNull() {
        activityRule.scenario.onActivity { activity ->
            assertThat(activity, `is`(notNullValue()))
        }
    }

    @Test
    fun startActivity_installSplash_isNotNull() {
        activityRule.scenario.moveToState(Lifecycle.State.CREATED)
        activityRule.scenario.onActivity { activity ->
            val splash = activity.installSplashScreen()
            assertThat(splash, `is`(notNullValue()))
        }
    }
}