plugins {
    alias(libs.plugins.runtracker.android.feature.ui)
}

android {
    namespace = "com.msmlabs.analytics.presentation"

}

dependencies {
    implementation(projects.analytics.domain)
}
