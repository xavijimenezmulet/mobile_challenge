plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.providerModule)

dependencies {
    UTILS
    addCommonDependencies()
}