plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.modelModule)

dependencies {
    addCommonDependencies()
}