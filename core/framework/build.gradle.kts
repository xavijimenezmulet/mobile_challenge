plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
}

configureAndroidLibrary(Namings.frameworkModule)

addComposeConfig()

dependencies {
    UTILS
    addCommonDependencies()
    addHiltDependency()
    addComposeDependencies()
    addPreferenceDependencies()
    implementation(Depends.hiltAndroidTesting)
}