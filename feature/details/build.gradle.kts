@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mobilebreakero.details"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdkTv.get().toInt()

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
    implementation(libs.androidx.core.ktx)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // compose material
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material)

    // compose navigation
    implementation(libs.androidx.navigation.compose)


    // lifecycle
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)


    // core Kotlin
    implementation(libs.androidx.core.ktx)

    // tv material
    implementation(libs.androidx.tv.material)
    implementation(libs.androidx.tv.foundation)

    // common module
    implementation(project(":common"))

    // coil compose
    implementation(libs.coil.compose)

    // youtube video player
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")

}