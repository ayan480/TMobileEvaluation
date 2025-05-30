plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)

    kotlin("kapt")
}

android {
    namespace = "com.syncoders.tmobileevaluation"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.syncoders.tmobileevaluation"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":core"))
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.compose.ui.ui)
    implementation(libs.androidx.compose.ui.ui)
    implementation(libs.androidx.storage)
    implementation(libs.androidx.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)



    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt (libs.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)
    implementation(libs.javapoet)




// Lifecycle components (optional but recommended)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.runtime.ktx)

    // For instrumentation tests
    androidTestImplementation  (libs.hilt.android.testing)
    androidTestAnnotationProcessor (libs.hilt.compiler)

    // For local unit tests
    testImplementation (libs.hilt.android.testing)
    testAnnotationProcessor (libs.hilt.compiler)



    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // ViewModel and LiveData
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)

    // Navigation
    implementation (libs.androidx.navigation.compose)


    //For changing status bar color
    implementation (libs.accompanist.systemuicontroller)
    implementation (libs.accompanist.navigation.animation.v0320)
    implementation (libs.androidx.material.icons.extended)

    implementation (libs.androidx.material)
    implementation (libs.androidx.navigation.compose)
    implementation (libs.androidx.foundation)


}