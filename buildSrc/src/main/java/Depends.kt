/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
object Depends {
    const val testRunnerPackage = "com.xavijimenezmulet.framework.CustomTestRunner"
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "kotlin-kapt"
    const val hiltPlugin = "dagger.hilt.android.plugin"
    const val symbolPlugin = "com.google.devtools.ksp"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltAndroidCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltAndroid}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltAndroid}"
    const val hiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"
    const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinPlugin}"
    const val hamcrest = "org.hamcrest:hamcrest:${Versions.hamcrest}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-core:${Versions.mockito}"
    const val androidTestCore = "androidx.test:core-ktx:${Versions.androidTestCore}"
    const val junitKotlin = "androidx.test.ext:junit-ktx:${Versions.junitKotlin}"
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    const val splashscreen = "androidx.core:core-splashscreen:${Versions.splashscreen}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val androidPaging = "androidx.paging:paging-runtime-ktx:${Versions.androidPaging}"
    const val datastorePref = "androidx.datastore:datastore-preferences:${Versions.datastorePref}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val testTruth = "androidx.test.ext:truth:${Versions.testTruth}"
    const val testJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragmentTesting}"
    const val fragmentKtx = "androidx.fragment:fragment:${Versions.fragmentKtx}"
    const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val testTurbine = "app.cash.turbine:turbine:${Versions.testTurbine}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val material3Compose = "androidx.compose.material3:material3:${Versions.material3}"
    const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.foundation}"
    const val materialIconCore =
        "androidx.compose.material:material-icons-core:${Versions.materialIcons}"
    const val materialIconExtended =
        "androidx.compose.material:material-icons-extended:${Versions.materialIcons}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelCompose}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintCompose}"
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottieCompose}"
    const val paging = "androidx.paging:paging-compose:${Versions.pagingCompose}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val swiperefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.swipe}"
    const val systemuicontroller =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.systemController}"
    const val insets = "com.google.accompanist:accompanist-insets:${Versions.systemController}"
    const val placeholderMaterial =
        "com.google.accompanist:accompanist-placeholder-material:${Versions.systemController}"
    const val navigationMaterial =
        "com.google.accompanist:accompanist-navigation-material:${Versions.systemController}"
    const val permissions =
        "com.google.accompanist:accompanist-permissions:${Versions.systemController}"
    const val pager = "com.google.accompanist:accompanist-pager:${Versions.systemController}"
    const val indicators =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.systemController}"
    const val webview = "com.google.accompanist:accompanist-webview:${Versions.webview}"
    const val datastore = "androidx.datastore:datastore:${Versions.datastore}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val securityPref = "androidx.security:security-crypto-ktx:${Versions.securityPref}"
    const val savedState = "androidx.savedstate:savedstate-ktx:${Versions.savedState}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    const val destinationCore =
        "io.github.raamcosta.compose-destinations:core:${Versions.destination}"
    const val destinationKsp =
        "io.github.raamcosta.compose-destinations:ksp:${Versions.destination}"
    const val destinationAnimation =
        "io.github.raamcosta.compose-destinations:animations-core:${Versions.destination}"
    const val kotlinSymbolProcessing =
        "com.google.devtools.ksp:symbol-processing-gradle-plugin:${Versions.kotlinSymbolProcessing}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiCodegen}"
    const val moshiLazyAdapter =
        "com.serjltt.moshi:moshi-lazy-adapters:${Versions.moshiLazyAdapter}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitMoshi}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chuckerDebug}"
    const val chuckerRelease =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerRelease}"
}
