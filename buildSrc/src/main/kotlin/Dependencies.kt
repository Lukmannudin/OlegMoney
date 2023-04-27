object App {
    const val appId = "com.ludi.olegmoney"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Sdk {
    const val apiLevelVersion = 33
    const val minApiLevelVersion = 24
}

object Versions {
    const val coreVersion = "1.10.0"
    const val lifecycleVersion = "2.6.1"
    const val activityVersion = "1.7.0"
    const val fragmentKtxVersion = "1.5.6"
    const val junitVersion = "4.13.2"
    const val testExtVersion = "1.1.5"
    const val testEspressoVersion = "3.5.1"
    const val jetpackComposeVersionBom = "2023.01.00"
    const val accompanistVersion = "0.27.1"
    const val navigationComposeVersion = "2.5.3"
    const val materialIconsComposeVersion = "1.4.1"
    const val retrofitVersion = "2.9.0"
    const val hiltVersion = "2.44"
    const val gmsVersion = "20.5.0"
    const val retromock = "1.1.1"
    const val composeMaterial3 = "1.0.1"
    const val composeUiTooling = "1.4.2"
}

object Dependencies {
    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifecyleViewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityVersion}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    }

    object Junit {
        const val jUnit = "junit:junit:${Versions.junitVersion}"
    }

    object AndroidXTest {
        const val extJUnit = "androidx.test.ext:junit:${Versions.testExtVersion}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.testEspressoVersion}"
    }

    object Compose {
        const val composeBom = "androidx.compose:compose-bom:${Versions.jetpackComposeVersionBom}"
        const val material3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUiTooling}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUiTooling}"
    }

    object ComposeMaterials {
        const val accompanistPager = "com.google.accompanist:accompanist-pager:${Versions.accompanistVersion}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"
        const val materialsIconExtended = "androidx.compose.material:material-icons-extended:${Versions.materialIconsComposeVersion}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    }

    object PlayServices {
        const val auth = "com.google.android.gms:play-services-auth:${Versions.gmsVersion}"
    }

    const val retromock = "co.infinum:retromock:${Versions.retromock}"

}