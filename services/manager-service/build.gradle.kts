plugins { alias(libs.plugins.agp.lib) }

android {
    buildFeatures { aidl = true }

    buildTypes { release { isMinifyEnabled = false } }

    namespace = "com.system.core.managerservice"
}

dependencies { api(libs.rikkax.parcelablelist) }
