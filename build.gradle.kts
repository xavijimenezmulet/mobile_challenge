buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (Depends.gradlePlugin)
        classpath (Depends.kotlinPlugin)
        classpath (Depends.hiltGradlePlugin)
        classpath(Depends.kotlinSymbolProcessing)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}