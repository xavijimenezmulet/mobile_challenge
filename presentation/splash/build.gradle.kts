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
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.splashscreen)
}
