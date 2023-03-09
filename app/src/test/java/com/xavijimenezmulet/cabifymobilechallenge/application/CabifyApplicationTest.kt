package com.xavijimenezmulet.cabifymobilechallenge.application

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * @author xavierjimenez
 * @since 9/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
@RunWith(AndroidJUnit4::class)
class CabifyApplicationTest {

    private lateinit var application: CabifyApplication

    @Before
    fun setup() {
        application = CabifyApplication()
    }

    @Test
    fun application_checkApplication_notNull() {
        application.onCreate()
        assertThat(ApplicationProvider.getApplicationContext(), `is`(notNullValue()))
    }

}