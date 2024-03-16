object App {
    const val appId = "com.ludi.olegmoney"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Sdk {
    const val apiLevelVersion = 33
    const val minApiLevelVersion = 24
}

object Plugins {
    const val androidAppVersion = "8.2.0"
    const val kotlinAndroidVersion = "1.8.10"
    const val hiltAndroidVersion = "2.50"
    const val detektVersion = "1.22.0"
    const val googleServicesVersion = "4.4.0"
}

object Versions {
    const val core = "1.10.0"
    const val lifecycle = "2.6.1"
    const val activity = "1.7.0"
    const val fragmentKtx = "1.5.6"
    const val junit = "4.13.2"
    const val testExt = "1.1.5"
    const val testEspresso = "3.5.1"
    const val jetpackComposeVersionBom = "2023.01.00"
    const val accompanist = "0.27.1"
    const val navigationCompose = "2.5.3"
    const val materialIconsCompose = "1.4.1"
    const val retrofit = "2.9.0"
    const val hilt = "2.44"
    const val gms = "20.5.0"
    const val retromock = "1.1.1"
    const val composeMaterial3 = "1.0.1"
    const val composeUiTooling = "1.4.2"
    const val moshi = "2.4.0"
    const val coroutines = "1.3.9"
    const val robolectric = "4.10.2"
    const val androidXTestVersion = "1.0.1"
    const val compose = "1.4.3"
    const val hiltNavigationCompose = "1.0.0"
    const val wire = "4.9.1"
    const val firebase = "32.7.0"
    const val chucker = "4.0.0"
    const val composeLifecycle = "2.6.2"
}

object Dependencies {
    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val lifecyleViewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activity}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    }

    object Junit {
        const val jUnit = "junit:junit:${Versions.junit}"
    }

    object Robolectric {
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    }

    object AndroidXTest {
        const val extJUnit = "androidx.test.ext:junit:${Versions.testExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
        const val runner = "androidx.test:runner:${Versions.androidXTestVersion}"
        const val rules = "androidx.test:rules:1.5.0"
    }

    object Compose {
        const val composeBom = "androidx.compose:compose-bom:${Versions.jetpackComposeVersionBom}"
        const val material3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.composeUiTooling}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUiTooling}"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.composeLifecycle}"
    }

    object ComposeMaterials {
        const val accompanistPager =
            "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        const val navigation =
            "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
        const val materialsIconExtended =
            "androidx.compose.material:material-icons-extended:${Versions.materialIconsCompose}"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
        const val hiltCompilerTest = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object PlayServices {
        const val auth = "com.google.android.gms:play-services-auth:${Versions.gms}"
    }

    object Moshi {
        const val converter = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
    }

    object Coroutines {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Wire {
        const val wireRuntime = "com.squareup.wire:wire-runtime:${Versions.wire}"
        const val wireCompiler = "com.squareup.wire:wire-compiler:${Versions.wire}"
    }

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:${Versions.firebase}"
        const val analytics = "com.google.firebase:firebase-analytics"
        const val config = "com.google.firebase:firebase-config"
    }

    object Chucker {
        const val debugLibrary = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
        const val releaseLibrary = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
    }

    const val retromock = "co.infinum:retromock:${Versions.retromock}"

}