plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.entityModule)

dependencies {
    addCommonDependencies()
}