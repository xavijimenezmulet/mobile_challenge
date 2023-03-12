plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.hiltPlugin)
}

configureAndroidLibrary(Namings.welcomeModule)

dependencies {
    USE_CASE
    FRAMEWORK
    THEME
    TEST_UTILS
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.splashscreen)
}