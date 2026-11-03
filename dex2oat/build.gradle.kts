plugins { alias(libs.plugins.agp.lib) }

android {
    namespace = "com.system.core.dex2oat"

    androidResources { enable = false }

    externalNativeBuild { cmake { path("src/main/cpp/CMakeLists.txt") } }
}
