plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
}

configureAndroidLibrary(Namings.frameworkModule)

dependencies {
    UTILS
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.hiltAndroidTesting)
}