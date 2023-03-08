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
  const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
  const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
  const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
  const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
  const val material = "com.google.android.material:material:${Versions.material}"
  const val constraintLayout =
    "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
  const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
  const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
  const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
  const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
  const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
  const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
  const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
  const val jsonSerialization =
    "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.jsonSerialization}"
  const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
  const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
  const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
  const val commandKuApi = "com.github.hadilq:command-ku-api:${Versions.commandKu}"
  const val commandKuImpl = "com.github.hadilq:command-ku-impl:${Versions.commandKu}"
  const val junit = "junit:junit:${Versions.junit}"
  const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiter}"
  const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiter}"
  const val mockk = "io.mockk:mockk:${Versions.mockk}"
  const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
  const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
