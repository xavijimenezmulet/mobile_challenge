plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.testutilsModule)

dependencies {
    addCommonDependencies()
}