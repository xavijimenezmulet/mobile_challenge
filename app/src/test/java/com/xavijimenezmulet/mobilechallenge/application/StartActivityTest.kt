package com.xavijimenezmulet.mobilechallenge.application

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.xavijimenezmulet.framework.base.application.CustomApplicationTest_Application
import com.xavijimenezmulet.splash.StartActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@Config(application = CustomApplicationTest_Application::class)
class StartActivityTest {


    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun startActivity_launchActivity_noReturn() {
        launchActivity<StartActivity>()
    }

}