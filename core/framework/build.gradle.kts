plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.frameworkModule)

dependencies {
    addCommonDependencies()
}