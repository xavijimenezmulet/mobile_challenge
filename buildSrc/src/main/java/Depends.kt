/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
object Depends {
    const val testRunnerPackage = "androidx.test.runner.AndroidJUnitRunner"
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "kotlin-kapt"
    const val hiltPlugin = "dagger.hilt.android.plugin"
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
}
