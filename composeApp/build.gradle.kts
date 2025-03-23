import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    //Basic plugins
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    //Serialization
    alias(libs.plugins.kotlin.serialization)
    //Ksp
    alias(libs.plugins.ksp)
    //Room
    alias(libs.plugins.room)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            //Basic impl
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            //Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            //Coil
            implementation(libs.ktor.client.android)
        }
        commonMain.dependencies {
            //Basic impl
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            //Material 3
            implementation(libs.androidx.material3)
            implementation(libs.material3.window.size)
            //Coil
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            //Lottie
            implementation(libs.lottie)
            //Ktor
            implementation(libs.bundles.ktor)
            implementation(libs.ktor.client.okhttp)
            //Koin
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.lifecycle.viewmodel)
            //Nav
            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.json)
            //Haze materials
            implementation(libs.haze)
            //For iterating over data classes
            implementation(kotlin("reflect"))
            //Room
            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)
        }
        desktopMain.dependencies {
            //Basic impl
            implementation(compose.desktop.currentOs)
            //Coroutines
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.kotlinx.coroutines.test)
            //Coil
            implementation(libs.ktor.client.java)
        }
    }
}

android {
    namespace = "com.example.mangaflow"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.mangaflow"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    //Compose tooling
    debugImplementation(compose.uiTooling)
    //Room
    ksp(libs.room.compiler)
}

compose.desktop {
    application {
        mainClass = "com.example.mangaflow.app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.example.mangaflow"
            packageVersion = "1.0.0"
        }
    }
}
