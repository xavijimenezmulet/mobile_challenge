package com.xavijimenezmulet.framework

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.xavijimenezmulet.framework.base.application.CustomApplicationTest_Application

class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, CustomApplicationTest_Application::class.java.name, context)
    }
}