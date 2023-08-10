@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mobilebreakero.details"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }


    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    with(packagingOptions) {
        resources {
            excludes.add("META-INF/gradle/incremental.annotation.processors")
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/LICENSE.txt")
        }
    }
}

dependencies {

    // jetpack compose
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.accompanist.placeholder)
    implementation(libs.androidx.lifecycle.runtime)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.materialWindow)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.coil.compose)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    //ViewModel && Lifecycle
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.runtime)

    // core Kotlin
    implementation(libs.androidx.core.ktx)

    // tv material
    implementation(libs.androidx.tv.material)
    implementation(libs.androidx.tv.foundation)

    // common module
    implementation(project(":common"))

    // Media3 ExoPlayer
    implementation(libs.media3.ui)
    implementation(libs.media3.exoplayer.dash)
    implementation(libs.media3.datasource.cronet)
    implementation(libs.media3.exoplayer)
    implementation(libs.androidx.media3.ui)

    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")

}