plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "com.msmlabs.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}
