plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.hiltPlugin)
    id(Depends.symbolPlugin)
}

configureAndroidLibrary(Namings.cartModule)

addComposeConfig()

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "cart")
}

android {

}

dependencies {
    CONSTANTS
    USE_CASE
    FRAMEWORK
    THEME
    TEST_UTILS
    PROVIDER
    UTILS
    ENTITY
    COMPONENT
    addCommonDependencies()
    addHiltDependency()
    addComposeDependencies()
    addNavigationDependencies()
}