plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.modelModule)

dependencies {
    ENTITY
    UTILS
    addCommonDependencies()
    addStorageDependencies()
    addNetworkDependency()
}