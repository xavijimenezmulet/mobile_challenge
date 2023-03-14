plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
}

configureAndroidLibrary(Namings.repositoryModule)

dependencies {
    FRAMEWORK
    CONSTANTS
    LOCAL
    REMOTE
    MODEL
    ENTITY
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.datastorePref)
}