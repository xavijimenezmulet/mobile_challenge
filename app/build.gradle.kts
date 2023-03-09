plugins {
    id(Depends.application)
    kotlin(ConfigData.android)
    kotlin(ConfigData.kapt)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = Namings.appModule
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = Depends.testRunnerPackage
    }

    buildTypes {
        getByName(ConfigData.debug) {
            signingConfig = signingConfigs.getByName(ConfigData.debug)
        }
        getByName(ConfigData.release) {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile(ConfigData.proguardTxt), ConfigData.proguardPro
            )
            signingConfig = signingConfigs.getByName(ConfigData.debug)
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf(ConfigData.xInlineClasses)
    }

    packagingOptions {
        resources.excludes.apply {
            add(Excludes.kotlinModule)
        }
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
    implementation(project(Modules.presentation))
    implementation(Depends.coreKtx)
    implementation(Depends.appCompat)
    implementation(Depends.material)
    implementation(Depends.hiltAndroid)
    testImplementation(Depends.junit)
    testImplementation(Depends.hamcrest)
    testImplementation(Depends.robolectric)
    testImplementation(Depends.mockito)
    testImplementation(Depends.mockitoInline)
    testImplementation(Depends.hiltAndroidTesting)
    testImplementation("androidx.test:core-ktx:1.5.0")
    testImplementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation(Depends.testExtJunit)
    androidTestImplementation(Depends.espressoCore)
}
