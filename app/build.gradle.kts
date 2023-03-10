plugins {
    id(Depends.application)
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = listOf(ConfigData.xInlineClasses)
    }

    packagingOptions {
        resources.excludes.apply {
            add(Excludes.kotlinModule)
        }
    }
}

dependencies {
    addModuleDependencies()
    addCommonDependencies()
    addHiltDependency()
}
