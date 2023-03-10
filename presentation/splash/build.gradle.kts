plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.splashModule)

dependencies {
    addCommonDependencies()
}
