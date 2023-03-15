plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.testutilsModule)

dependencies {
    addCommonDependencies()
    implementation(Depends.junit)
    implementation(Depends.coroutinesTest)
    implementation(Depends.mockk)
    implementation(Depends.robolectric)
    implementation(Depends.moshi)
    implementation(Depends.hamcrest)
}