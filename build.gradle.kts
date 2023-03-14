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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}