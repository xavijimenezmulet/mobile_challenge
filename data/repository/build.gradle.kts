plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.repositoryModule)

dependencies {
    addCommonDependencies()
}