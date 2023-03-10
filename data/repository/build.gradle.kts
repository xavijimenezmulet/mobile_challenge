plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
    id(Depends.kotlinKapt)
}

configureAndroidLibrary(Namings.repositoryModule)

dependencies {
    FRAMEWORK
    CONSTANTS
    addCommonDependencies()
    addHiltDependency()
    implementation(Depends.datastorePref)
}