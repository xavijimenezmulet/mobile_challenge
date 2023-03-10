buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (Depends.gradlePlugin)
        classpath (Depends.kotlinPlugin)
        classpath (Depends.hiltGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}