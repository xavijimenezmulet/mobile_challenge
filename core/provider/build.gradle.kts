plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.providerModule)

addComposeConfig()

dependencies {
    UTILS
    addCommonDependencies()
    addComposeDependencies()
}