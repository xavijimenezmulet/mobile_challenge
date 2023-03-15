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
    TEST_UTILS
    ENTITY
    addCommonDependencies()
    addHiltDependency()
    addTestDependencies()
    addStorageDependencies()
    addPreferenceDependencies()
}