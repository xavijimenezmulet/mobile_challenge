plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.remoteModule)

dependencies {
    addCommonDependencies()
}