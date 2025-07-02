plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.damn_practica10"
    compileSdk = 34 // Puedes usar una versión reciente

    defaultConfig {
        applicationId = "com.example.damn_practica10"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        viewBinding = true // Habilitamos View Binding para facilidad
    }
}

dependencies {

    // Dependencias estándar de AndroidX
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Dependencias clave para Android TV (Leanback)
    implementation("androidx.leanback:leanback:1.0.0")

    // Glide para cargar imágenes (muy útil en Leanback)
    implementation("com.github.bumptech.glide:glide:4.16.0")

}
