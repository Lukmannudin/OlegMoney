
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
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

    // test
    testImplementation(Dependencies.Junit.jUnit)
    androidTestImplementation(Dependencies.AndroidXTest.extJUnit)
    androidTestImplementation(Dependencies.AndroidXTest.espressoCore)

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

    // retrofit
    implementation(Dependencies.Retrofit.retrofit)

    // hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    // play services
    implementation(Dependencies.PlayServices.auth)

    // retromock
    implementation(Dependencies.retromock)
}
