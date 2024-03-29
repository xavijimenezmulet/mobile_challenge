plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.testutilsModule)

dependencies {
    addCommonDependencies()
    implementation(Depends.junit)
    implementation(Depends.coroutinesTest)
    implementation(Depends.mockk)
    implementation(Depends.robolectric)
    implementation(Depends.moshi)
    addNetworkDependency()
    api(Depends.mockWebServer)
    implementation(Depends.hamcrest)
}