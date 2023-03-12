package com.xavijimenezmulet.splash

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UnitTestWithContextTest {

    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun givenContext_whenPackageName_containsSplashPackage() {
        assertThat(context.packageName).contains("com.xavijimenezmulet.splash")
    }
}