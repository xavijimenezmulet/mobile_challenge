package com.xavijimenezmulet.mobilechallenge.application

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author xavierjimenez
 * @since 9/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
@RunWith(AndroidJUnit4::class)
class MobileChallengeApplicationTest {

    private lateinit var application: MobileChallengeApplication

    @Before
    fun setup() {
        application = MobileChallengeApplication()
    }

    @Test
    fun application_checkApplication_notNull() {
        application.onCreate()
        assertThat(ApplicationProvider.getApplicationContext(), `is`(notNullValue()))
    }

}