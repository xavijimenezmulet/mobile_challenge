plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.hiltPlugin)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.homeModule)

addComposeConfig()

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "home")
}

dependencies {
    USE_CASE
    FRAMEWORK
    THEME
    TEST_UTILS
    PROVIDER
    UTILS
    PRODUCTS
    addCommonDependencies()
    addHiltDependency()
    addComposeDependencies()
    addNavigationDependencies()
}
