plugins {
    id(Depends.application)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.hiltPlugin)
    id(Depends.symbolPlugin)
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
            buildConfigField("String","BASE_URL", Configs.Debug.BaseUrl)
            buildConfigField("String","DB_NAME", Configs.Debug.DbName)
            signingConfig = signingConfigs.getByName(ConfigData.debug)
        }
        getByName(ConfigData.release) {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            buildConfigField("String","BASE_URL", Configs.Release.BaseUrl)
            buildConfigField("String","DB_NAME", Configs.Release.DbName)
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    packagingOptions {
        resources.excludes.apply {
            add(Excludes.kotlinModule)
        }
    }
}

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    addModuleDependencies()
    addCommonDependencies()
    addHiltDependency()
    addComposeDependencies()
    addNavigationDependencies()

}
