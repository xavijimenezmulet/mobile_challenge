plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.componentModule)

addComposeConfig()

dependencies {
    THEME
    FRAMEWORK
    addCommonDependencies()
    addComposeDependencies()
}
