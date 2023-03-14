plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id("kotlin-parcelize")
}

configureAndroidLibrary(Namings.entityModule)

dependencies {
    addCommonDependencies()
}