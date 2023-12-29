plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "fr.dev.majdi.boxotop"
    compileSdk = 34

    defaultConfig {
        applicationId = "fr.dev.majdi.boxotop"
        minSdk = 24
        targetSdk = 34
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    // jetpack compose
    implementation(platform(libs.androidx.compose.boom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphic)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.activity.compose)

    // hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
    kapt(libs.hilt.compiler)
    // logging
    implementation(libs.timber)
    // lottie lib animation (I add optional splash)
    implementation(libs.lottie)
    // navigation compose
    implementation(libs.navigation.compose)
    // coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.coroutines.adapter)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.retrofit.logging.interceptor)
    // moshi for parsing JSON
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    kapt(libs.moshi.kotlin.codegen)
    // coil
    implementation(libs.coil)
    // lifecycle compose
    implementation(libs.androidx.compose.lifecycle)
    // icons lib
    implementation(libs.androidx.compose.material.icons.extended)

    // tests
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.junit)

    // testing retrofit responses
    androidTestImplementation(libs.mockito.kotlin)
    androidTestImplementation(libs.mock.web.server)

}