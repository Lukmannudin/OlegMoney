import org.jetbrains.kotlin.serialization.builtins.main

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

apply {
    from("${project.rootDir}/gradle-scripts/script-wire.gradle")
}

android {
    namespace = App.appId
    compileSdk = Sdk.apiLevelVersion

    defaultConfig {
        applicationId = App.appId
        minSdk = Sdk.minApiLevelVersion
        targetSdk = Sdk.apiLevelVersion
        versionCode = App.versionCode
        versionName = App.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of("11"))
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    packagingOptions {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }

    externalNativeBuild {
        cmake {
            path = File("CMakeLists.txt")
        }
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {

    // androidx
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    implementation(Dependencies.AndroidX.lifecyleViewModelCompose)
    implementation(Dependencies.AndroidX.activityCompose)
    implementation(Dependencies.AndroidX.fragmentKtx)
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation(project(mapOf("path" to ":sharedkmm")))

    // test
    testImplementation(Dependencies.Junit.jUnit)
    testImplementation(Dependencies.Robolectric.robolectric)
    androidTestImplementation(Dependencies.AndroidXTest.extJUnit)
    androidTestImplementation(Dependencies.AndroidXTest.espressoCore)
    androidTestImplementation(Dependencies.AndroidXTest.runner)
    androidTestImplementation(Dependencies.AndroidXTest.rules)
    androidTestImplementation(Dependencies.Compose.uiTest)
    debugImplementation(Dependencies.Compose.uiTestManifest)

    // jetpack compose bom
    implementation(Dependencies.Compose.composeBom)
    androidTestImplementation(Dependencies.Compose.composeBom)
    implementation(Dependencies.Compose.material3)

    // Android Studio Preview support
    implementation(Dependencies.Compose.uiToolingPreview)
    debugImplementation(Dependencies.Compose.uiTooling)

    // jetpack compose materials
    implementation(Dependencies.ComposeMaterials.accompanistPager)
    implementation(Dependencies.ComposeMaterials.navigation)
    implementation(Dependencies.ComposeMaterials.materialsIconExtended)
    implementation(Dependencies.ComposeMaterials.hiltNavigation)

    // retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)
    testImplementation(Dependencies.Hilt.hiltAndroidTest)
    kaptTest(Dependencies.Hilt.hiltCompilerTest)

    // play services
    implementation(Dependencies.PlayServices.auth)

    // retromock
    implementation(Dependencies.retromock)

    // moshi
    implementation(Dependencies.Moshi.converter)

    // coroutines
    implementation(Dependencies.Coroutines.coroutines)
    testImplementation(Dependencies.Coroutines.coroutinesTest)

    // wire
    implementation(Dependencies.Wire.wireRuntime)

    // firebase
    implementation(platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.analytics)
    implementation(Dependencies.Firebase.config)

    // chucker
    debugImplementation(Dependencies.Chucker.debugLibrary)
    releaseImplementation(Dependencies.Chucker.releaseLibrary)

    // compose
    implementation(Dependencies.Compose.lifecycle)
}

hilt {
    enableTransformForLocalTests = true
}
