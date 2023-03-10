plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.utilsModule)

dependencies {
    addCommonDependencies()
}