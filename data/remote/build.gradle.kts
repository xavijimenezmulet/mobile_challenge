plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.remoteModule)

dependencies {
    MODEL
    FRAMEWORK
    TEST_UTILS
    addCommonDependencies()
    addHiltDependency()
    addNetworkDependency()
}