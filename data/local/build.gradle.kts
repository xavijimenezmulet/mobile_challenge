plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.localModule)

dependencies {
    UTILS
    MODEL
    FRAMEWORK
    addCommonDependencies()
    addHiltDependency()
    addTestDependencies()
    addStorageDependencies()
    addPreferenceDependencies()
}