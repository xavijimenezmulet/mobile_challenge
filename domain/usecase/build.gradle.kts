plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
    id(Depends.hiltPlugin)
}

configureAndroidLibrary(Namings.usecaseModule)

dependencies {
    ENTITY
    MODEL
    REPOSITORY
    FRAMEWORK
    addCommonDependencies()
    addHiltDependency()
}