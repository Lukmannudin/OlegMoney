plugins {
    id("com.android.application") version Plugins.androidAppVersion apply false
    id("com.android.library") version Plugins.androidAppVersion apply false
    id("org.jetbrains.kotlin.android") version Plugins.kotlinAndroidVersion apply false
    id("com.google.dagger.hilt.android") version Plugins.hiltAndroidVersion apply false
    id("io.gitlab.arturbosch.detekt") version Plugins.detektVersion
}

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
    }
}

