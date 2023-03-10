plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.localModule)

dependencies {
    addCommonDependencies()
}