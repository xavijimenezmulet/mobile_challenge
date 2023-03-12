plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.hiltPlugin)
}

configureAndroidLibrary(Namings.splashModule)

dependencies {
    USE_CASE
    FRAMEWORK
    THEME
    TEST_UTILS
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.splashscreen)
    testImplementation("app.cash.turbine:turbine:0.7.0")
}
