plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.presentationModule)

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
    implementation(Depends.coreKtx)
    implementation(Depends.appCompat)
    implementation(Depends.material)
    testImplementation(Depends.junit)
    androidTestImplementation(Depends.testExtJunit)
    androidTestImplementation(Depends.espressoCore)
}