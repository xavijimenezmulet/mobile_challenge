plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
}

configureAndroidLibrary(Namings.themeModule)

addComposeConfig()

dependencies {
    addCommonDependencies()
    addComposeDependencies()
    implementation(Depends.splashscreen)
}