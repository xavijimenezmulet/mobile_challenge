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
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.datastorePref)
}