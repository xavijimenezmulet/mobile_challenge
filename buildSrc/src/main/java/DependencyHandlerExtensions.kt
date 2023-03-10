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
}

fun DependencyHandler.addHiltDependency() {
    implementation(Depends.hiltAndroid)
    testImplementation(Depends.hiltAndroidTesting)
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
    androidTestImplementation(Depends.testExtJunit)
    androidTestImplementation(Depends.espressoCore)
}

fun DependencyHandler.addModuleDependencies() {
    implementation(project(mapOf("path" to ":data:model")))
    implementation(project(mapOf("path" to ":data:local")))
    implementation(project(mapOf("path" to ":data:remote")))
    implementation(project(mapOf("path" to ":data:repository")))
    implementation(project(mapOf("path" to ":domain")))

    implementation(project(mapOf("path" to ":common:provider")))
    implementation(project(mapOf("path" to ":common:theme")))
    implementation(project(mapOf("path" to ":common:component")))

    implementation(project(mapOf("path" to ":libraries:framework")))
    implementation(project(mapOf("path" to ":libraries:jetframework")))

    implementation(project(mapOf("path" to ":features:welcome")))
    implementation(project(mapOf("path" to ":features:locations")))
    implementation(project(mapOf("path" to ":features:episodes")))
    implementation(project(mapOf("path" to ":features:settings")))
    implementation(project(mapOf("path" to ":features:characters")))
    implementation(project(mapOf("path" to ":features:splash")))
    implementation(project(mapOf("path" to ":features:home")))
}