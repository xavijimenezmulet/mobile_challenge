plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.utilsModule)

dependencies {
    addCommonDependencies()
    implementation(Depends.moshi)
}