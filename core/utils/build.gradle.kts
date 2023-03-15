plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.utilsModule)

dependencies {
    CONSTANTS
    ENTITY
    addCommonDependencies()
    addComposeDependencies()
    implementation(Depends.moshi)
}