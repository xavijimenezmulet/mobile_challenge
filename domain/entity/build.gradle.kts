plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.parcelizePlugin)
}

configureAndroidLibrary(Namings.entityModule)

dependencies {
    TEST_UTILS
    addCommonDependencies()
}