plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.componentModule)

dependencies {
    addCommonDependencies()
}
