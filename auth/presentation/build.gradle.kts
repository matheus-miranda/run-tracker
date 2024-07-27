plugins {
    alias(libs.plugins.runtracker.android.feature.ui)
}

android {
    namespace = "com.msmlabs.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}
