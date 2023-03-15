plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.modelModule)

dependencies {
    ENTITY
    UTILS
    TEST_UTILS
    addCommonDependencies()
    addStorageDependencies()
    addNetworkDependency()
    api(Depends.json)
}