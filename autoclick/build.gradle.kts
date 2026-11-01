plugins {
    id("com.android.application")
}

android {
    namespace = "com.he.autoclick"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.he.autoclick"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    compileOnly(project(":xposed"))
}
