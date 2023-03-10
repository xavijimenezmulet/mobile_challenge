plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.themeModule)

dependencies {
    addCommonDependencies()
}