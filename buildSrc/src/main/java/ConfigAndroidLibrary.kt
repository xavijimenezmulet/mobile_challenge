/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun Project.configureAndroidLibrary(name: String) {
    androidLibrary {
        namespace = name
        compileSdk = Versions.compileSdk

        defaultConfig {
            minSdk = Versions.minSdk
            targetSdk = Versions.targetSdk

            testInstrumentationRunner = Depends.testRunnerPackage
            consumerProguardFiles(ConfigData.consumerRules)
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        testOptions {
            unitTests.isIncludeAndroidResources = true
        }

        kotlinOptions {
            jvmTarget = Versions.jvmTarget
        }
    }
}

/**
 * Configures the [android][LibraryExtension] extension.
 */
fun Project.androidLibrary(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

/**
 * Configures the [kotlinOptions][KotlinJvmOptions] extension.
 */
fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)



