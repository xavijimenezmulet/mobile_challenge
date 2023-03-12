/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Adds a dependency to the `releaseImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? =
    add("kaptTest", dependencyNotation)

fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? =
    add("kaptAndroidTest", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds a dependency to the `ksp` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? =
    add("ksp", dependencyNotation)

fun DependencyHandler.addCommonDependencies() {
    addCommonImplDependencies()
    addTestDependencies()
}

fun DependencyHandler.addCommonImplDependencies() {
    implementation(Depends.coreKtx)
    implementation(Depends.appCompat)
    implementation(Depends.material)
    implementation(Depends.coroutineCore)
    implementation(Depends.coroutineAndroid)
    implementation(Depends.lifecycleRuntime)
    implementation(Depends.activityKtx)
    implementation(Depends.timber)
    implementation(Depends.androidPaging)
    implementation("com.squareup:javapoet:1.13.0")
}

fun DependencyHandler.addHiltDependency() {
    implementation(Depends.hiltAndroid)
    implementation(Depends.hiltCompose)
    kapt(Depends.hiltCompiler)
    kaptTest(Depends.hiltAndroidCompiler)
    testImplementation(Depends.hiltAndroidTesting)
    androidTestImplementation(Depends.hiltAndroidTesting)
    androidTestImplementation(Depends.hiltAndroidTesting)
}

fun DependencyHandler.addTestDependencies() {
    testImplementation(Depends.junit)
    testImplementation(Depends.hamcrest)
    testImplementation(Depends.robolectric)
    testImplementation(Depends.mockito)
    testImplementation(Depends.mockitoInline)
    testImplementation(Depends.androidTestCore)
    testImplementation(Depends.junitKotlin)
    testImplementation(Depends.archCoreTest)
    testImplementation(Depends.mockk)
    testImplementation(Depends.coroutinesTest)
    testImplementation(Depends.testTruth)
    testImplementation(Depends.testJunit4)
    testImplementation(Depends.testTurbine)
    androidTestImplementation(Depends.androidTestCore)
    androidTestImplementation(Depends.robolectric)
    androidTestImplementation(Depends.testExtJunit)
    androidTestImplementation(Depends.espressoCore)
    debugImplementation(Depends.fragmentTesting)
    debugImplementation(Depends.testManifest)
}

fun DependencyHandler.addModuleDependencies() {
    COMPONENT
    CONSTANTS
    FRAMEWORK
    PROVIDER
    TEST_UTILS
    THEME
    UTILS
    LOCAL
    MODEL
    REMOTE
    REPOSITORY
    ENTITY
    USE_CASE
    SPLASH
}

val DependencyHandler.COMPONENT
    get() = implementation(project(mapOf("path" to Modules.coreComponent)))
val DependencyHandler.CONSTANTS
    get() = implementation(project(mapOf("path" to Modules.coreConstants)))
val DependencyHandler.FRAMEWORK
    get() = implementation(project(mapOf("path" to Modules.coreFramework)))
val DependencyHandler.PROVIDER
    get() = implementation(project(mapOf("path" to Modules.coreProvider)))
val DependencyHandler.TEST_UTILS
    get() = implementation(project(mapOf("path" to Modules.coreTestUtils)))
val DependencyHandler.THEME
    get() = implementation(project(mapOf("path" to Modules.coreTheme)))
val DependencyHandler.UTILS
    get() = implementation(project(mapOf("path" to Modules.coreUtils)))
val DependencyHandler.LOCAL
    get() = implementation(project(mapOf("path" to Modules.dataLocal)))
val DependencyHandler.MODEL
    get() = implementation(project(mapOf("path" to Modules.dataModel)))
val DependencyHandler.REMOTE
    get() = implementation(project(mapOf("path" to Modules.dataRemote)))
val DependencyHandler.REPOSITORY
    get() = implementation(project(mapOf("path" to Modules.dataRepository)))
val DependencyHandler.ENTITY
    get() = implementation(project(mapOf("path" to Modules.domainEntity)))
val DependencyHandler.USE_CASE
    get() = implementation(project(mapOf("path" to Modules.domainUseCase)))
val DependencyHandler.SPLASH
    get() = implementation(project(mapOf("path" to Modules.presentationSplash)))
