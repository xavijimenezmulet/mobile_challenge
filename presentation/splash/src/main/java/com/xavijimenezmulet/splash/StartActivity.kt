package com.xavijimenezmulet.splash

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.xavijimenezmulet.utils.extension.launchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@AndroidEntryPoint
class StartActivity : ComponentActivity() {

    private val viewModel by viewModels<StartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.startWelcome.collectLatest {
                    delay(3000)
                    if (it) navigateWelcomeActivity() else navigateMainActivity()
                }
            }
        }
    }

    private fun navigateMainActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.xavijimenezmulet.mobilechallenge.navigation.MainActivity"
        ).also {
            finish()
        }
    }

    private fun navigateWelcomeActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.xavijimenezmulet.welcome.WelcomeActivity"
        ).also {
            finish()
        }
    }
}